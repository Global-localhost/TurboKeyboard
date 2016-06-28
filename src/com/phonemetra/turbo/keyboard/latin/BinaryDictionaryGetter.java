/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.phonemetra.turbo.keyboard.latin;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.phonemetra.turbo.keyboard.latin.common.LocaleUtils;
import com.phonemetra.turbo.keyboard.latin.makedict.DictionaryHeader;
import com.phonemetra.turbo.keyboard.latin.makedict.UnsupportedFormatException;
import com.phonemetra.turbo.keyboard.latin.utils.BinaryDictionaryUtils;
import com.phonemetra.turbo.keyboard.latin.utils.DictionaryInfoUtils;

import java.io.File;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;


final public class BinaryDictionaryGetter {
	
    private static final File[] EMPTY_FILE_ARRAY = new File[0];
    private static final String COMMON_PREFERENCES_NAME = "LatinImeDictPrefs";
    private static final boolean SHOULD_USE_DICT_VERSION = true;
         
    // Name of the category for the main dictionary
    public static final String MAIN_DICTIONARY_CATEGORY = "main";
    public static final String ID_CATEGORY_SEPARATOR = ":";

    // The key considered to read the version attribute in a dictionary file.
    private static String VERSION_KEY = "version";

    // Prevents this from being instantiated
    private BinaryDictionaryGetter() {}

    /**
     * Generates a unique temporary file name in the app cache directory.
     */
    public static String getTempFileName(final String id, final Context context)
            throws IOException {
    	
        final String safeId = DictionaryInfoUtils.replaceFileNameDangerousCharacters(id);
        
        final File directory = new File(DictionaryInfoUtils.getWordListTempDirectory(context));
        
        // If the first argument is less than three chars, createTempFile throws a
        // RuntimeException. We don't really care about what name we get, so just
        // put a three-chars prefix makes us safe.
        return File.createTempFile("xxx" + safeId, null, directory).getAbsolutePath();
    }

//    /**
//     * Returns a file address from a resource, or null if it cannot be opened.
//     */
//    public static AssetFileAddress loadFallbackResource(final Context context,
//            final int fallbackResId) {
//        AssetFileDescriptor afd = null;
//        try {
//        	 if (0 == fallbackResId) return null;
//        	 afd = context.getResources().openRawResourceFd(fallbackResId);
//             if (afd == null) {
//                 Log.e("BinaryDictionaryGetter", "Found the resource but it is compressed. resId=" + fallbackResId);
//                 return null;
//             }
//             final String sourceDir = context.getApplicationInfo().sourceDir;
//             final File packagePath = new File(sourceDir);
//             // TODO: Come up with a way to handle a directory.
//             if (!packagePath.isFile()) {
//                 Log.e("BinaryDictionaryGetter", "sourceDir is not a file: " + sourceDir);
//                 return null;
//             }
//        
//             return AssetFileAddress.makeFromFileNameAndOffset(
//            		 sourceDir, afd.getStartOffset(), afd.getLength());
//        } catch (android.content.res.Resources.NotFoundException e) {
//            Log.e("BinaryDictionaryGetter", "Could not find the resource");
//            return null;
//        } finally {
//            if (null != afd) {
//                try {
//                    afd.close();
//                } catch (java.io.IOException e) {
//                    /* IOException on close ? What am I supposed to do ? */
//                }
//            }
//       }
//    }

    private static final class DictPackSettings {
        final SharedPreferences mDictPreferences;
        
        public DictPackSettings(final Context context) {
            mDictPreferences = context.getSharedPreferences(COMMON_PREFERENCES_NAME,
                            Context.MODE_MULTI_PROCESS);
            Log.i("DictPackSettings", "mDictPreferences: " + mDictPreferences);
            
        }
        public boolean isWordListActive(final String dictId) {
            
        	if (mDictPreferences!=null) {
        		return mDictPreferences.getBoolean(dictId, true);
        	} else {
        		return false;
        	}
        }
    }

    /**
     * Utility class for the {@link #getCachedWordLists} method
     */
    private static final class FileAndMatchLevel {
        final File mFile;
        final int mMatchLevel;
        public FileAndMatchLevel(final File file, final int matchLevel) {
            mFile = file;
            mMatchLevel = matchLevel;
        }
    }

    /**
     * Returns the list of cached files for a specific locale, one for each category.
     *
     * This will return exactly one file for each word list category that matches
     * the passed locale. If several files match the locale for any given category,
     * this returns the file with the closest match to the locale. For example, if
     * the passed word list is en_US, and for a category we have an en and an en_US
     * word list available, we'll return only the en_US one.
     * Thus, the list will contain as many files as there are categories.
     *
     * @param locale the locale to find the dictionary files for, as a string.
     * @param context the context on which to open the files upon.
     * @return an array of binary dictionary files, which may be empty but may not be null.
     */
    public static File[] getCachedWordLists(final String locale, final Context context) {
        final File[] directoryList = DictionaryInfoUtils.getCachedDirectoryList(context);
        if (null == directoryList) return EMPTY_FILE_ARRAY;
        final HashMap<String, FileAndMatchLevel> cacheFiles = new HashMap<>();
        for (File directory : directoryList) {
            if (!directory.isDirectory()) continue;
            final String dirLocale =
                    DictionaryInfoUtils.getWordListIdFromFileName(directory.getName());
            final int matchLevel = LocaleUtils.getMatchLevel(dirLocale, locale);
            if (LocaleUtils.isMatch(matchLevel)) {
                final File[] wordLists = directory.listFiles();
                if (null != wordLists) {
                    for (File wordList : wordLists) {
                        final String category =
                                DictionaryInfoUtils.getCategoryFromFileName(wordList.getName());
                        final FileAndMatchLevel currentBestMatch = cacheFiles.get(category);
                        if (null == currentBestMatch || currentBestMatch.mMatchLevel < matchLevel) {
                            cacheFiles.put(category, new FileAndMatchLevel(wordList, matchLevel));
                        }
                    }
                }
            }
        }
        if (cacheFiles.isEmpty()) return EMPTY_FILE_ARRAY;
        final File[] result = new File[cacheFiles.size()];
        int index = 0;
        for (final FileAndMatchLevel entry : cacheFiles.values()) {
            result[index++] = entry.mFile;
        }
        return result;
    }

    // ## HACK ## we prevent usage of a dictionary before version 18. The reason for this is, since
    // those do not include whitelist entries, the new code with an old version of the dictionary
    // would lose whitelist functionality.
    private static boolean hackCanUseDictionaryFile(final File file) {
        if (!SHOULD_USE_DICT_VERSION) {
            return true;
        }

        try {
            // Read the version of the file
            final DictionaryHeader header = BinaryDictionaryUtils.getHeader(file);
            final String version = header.mDictionaryOptions.mAttributes.get(VERSION_KEY);
            if (null == version) {
                // No version in the options : the format is unexpected
                return false;
            }
            // Version 18 is the first one to include the whitelist
            // Obviously this is a big ## HACK ##
            return Integer.parseInt(version) >= 18;
        } catch (java.io.FileNotFoundException e) {
            return false;
        } catch (java.io.IOException e) {
            return false;
        } catch (NumberFormatException e) {
            return false;
        } catch (BufferUnderflowException e) {
            return false;
        } catch (UnsupportedFormatException e) {
            return false;
        }
    }

    /**
     * Returns a list of file addresses for a given locale, trying relevant methods in order.
     *
     * Tries to get binary dictionaries from various sources, in order:
     * - Uses a content provider to get a public dictionary set, as per the protocol described
     *   in BinaryDictionaryFileDumper.
     * If that fails:
     * - Gets a file name from the built-in dictionary for this locale, if any.
     * If that fails:
     * - Returns null.
     * @return The list of addresses of valid dictionary files, or null.
     */
    public static ArrayList<AssetFileAddress> getDictionaryFiles(final Locale locale,
            final Context context, boolean notifyDictionaryPackForUpdates) {
    	
    	
        if (notifyDictionaryPackForUpdates) {
            final boolean hasDefaultWordList = DictionaryInfoUtils.isDictionaryAvailable(
                    context, locale);
           
            BinaryDictionaryFileDumper.downloadDictIfNeverRequested(
                    locale, context, hasDefaultWordList);

            DictionaryInfoUtils.moveStagingFilesIfExists(context);
        }
        final File[] cachedWordLists = getCachedWordLists(locale.toString(), context);
        final String mainDictId = DictionaryInfoUtils.getMainDictId(locale);
        final DictPackSettings dictPackSettings = new DictPackSettings(context);

        boolean foundMainDict = false;
        final ArrayList<AssetFileAddress> fileList = new ArrayList<>();
        // cachedWordLists may not be null, see doc for getCachedDictionaryList
        for (final File f : cachedWordLists) {
            final String wordListId = DictionaryInfoUtils.getWordListIdFromFileName(f.getName());
            final boolean canUse = f.canRead() && hackCanUseDictionaryFile(f);
            if (canUse && DictionaryInfoUtils.isMainWordListId(wordListId)) {
                foundMainDict = true;
            }
            if (!dictPackSettings.isWordListActive(wordListId)) continue;
            if (canUse) {
                final AssetFileAddress afa = AssetFileAddress.makeFromFileName(f.getPath());
                if (null != afa) fileList.add(afa);
            } else {
                Log.e("BinaryDictionaryGetter", "Found a cached dictionary file for " + locale.toString()
                        + " but cannot read or use it");
            }
        }

        //if (!foundMainDict && dictPackSettings.isWordListActive(mainDictId)) {
        //    final int fallbackResId =
        //            DictionaryInfoUtils.getMainDictionaryResourceId(context.getResources(), locale);
        //    final AssetFileAddress fallbackAsset = loadFallbackResource(context, fallbackResId);
        //    if (null != fallbackAsset) {
        //        fileList.add(fallbackAsset);
        //    }
        //}

        return fileList;
    }
}
