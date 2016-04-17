/*
 * Copyright (C) 2013 The Android Open Source Project
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

package com.phonemetra.turbo.keyboard.latin.utils;

import com.phonemetra.turbo.keyboard.dictionarypack.DictionarySettingsFragment;
import com.phonemetra.turbo.keyboard.latin.settings.BuildSettingsFragment;
import com.phonemetra.turbo.keyboard.latin.settings.AccountsSettingsFragment;
import com.phonemetra.turbo.keyboard.latin.settings.AdvancedSettingsFragment;
import com.phonemetra.turbo.keyboard.latin.settings.AppearanceSettingsFragment;
import com.phonemetra.turbo.keyboard.latin.settings.CorrectionSettingsFragment;
import com.phonemetra.turbo.keyboard.latin.settings.CustomInputStyleSettingsFragment;
import com.phonemetra.turbo.keyboard.latin.settings.GestureSettingsFragment;
import com.phonemetra.turbo.keyboard.latin.settings.PreferencesSettingsFragment;
import com.phonemetra.turbo.keyboard.latin.settings.SettingsFragment;
import com.phonemetra.turbo.keyboard.latin.settings.ThemeSettingsFragment;
import com.phonemetra.turbo.keyboard.latin.spellcheck.SpellCheckerSettingsFragment;
import com.phonemetra.turbo.keyboard.latin.userdictionary.UserDictionaryAddWordFragment;
import com.phonemetra.turbo.keyboard.latin.userdictionary.UserDictionaryList;
import com.phonemetra.turbo.keyboard.latin.userdictionary.UserDictionaryLocalePicker;
import com.phonemetra.turbo.keyboard.latin.userdictionary.UserDictionarySettings;

import java.util.HashSet;

public class FragmentUtils {
    private static final HashSet<String> sLatinImeFragments = new HashSet<>();
    static {
        sLatinImeFragments.add(DictionarySettingsFragment.class.getName());
        sLatinImeFragments.add(BuildSettingsFragment.class.getName());
        sLatinImeFragments.add(PreferencesSettingsFragment.class.getName());
        sLatinImeFragments.add(AccountsSettingsFragment.class.getName());
        sLatinImeFragments.add(AppearanceSettingsFragment.class.getName());
        sLatinImeFragments.add(ThemeSettingsFragment.class.getName());
        sLatinImeFragments.add(CustomInputStyleSettingsFragment.class.getName());
        sLatinImeFragments.add(GestureSettingsFragment.class.getName());
        sLatinImeFragments.add(CorrectionSettingsFragment.class.getName());
        sLatinImeFragments.add(AdvancedSettingsFragment.class.getName());
        sLatinImeFragments.add(SettingsFragment.class.getName());
        sLatinImeFragments.add(SpellCheckerSettingsFragment.class.getName());
        sLatinImeFragments.add(UserDictionaryAddWordFragment.class.getName());
        sLatinImeFragments.add(UserDictionaryList.class.getName());
        sLatinImeFragments.add(UserDictionaryLocalePicker.class.getName());
        sLatinImeFragments.add(UserDictionarySettings.class.getName());
    }

    public static boolean isValidFragment(String fragmentName) {
        return sLatinImeFragments.contains(fragmentName);
    }
}
