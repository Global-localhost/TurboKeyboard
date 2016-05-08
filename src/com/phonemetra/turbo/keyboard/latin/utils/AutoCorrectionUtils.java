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

package com.phonemetra.turbo.keyboard.latin.utils;

import android.util.Log;

import com.phonemetra.turbo.keyboard.latin.SuggestedWords.SuggestedWordInfo;

public final class AutoCorrectionUtils {
    private static final boolean DBG = false;
    private static final String TAG = AutoCorrectionUtils.class.getSimpleName();

    private AutoCorrectionUtils() {
       
    }

    public static boolean suggestionExceedsThreshold(final SuggestedWordInfo suggestion,
            final String consideredWord, final float threshold) {
        if (null != suggestion) {
            // Shortlist a whitelisted word
            if (suggestion.isKindOf(SuggestedWordInfo.KIND_WHITELIST)) {
                return true;
            }
            // TODO: return suggestion.isAprapreateForAutoCorrection();
            if (!suggestion.isAprapreateForAutoCorrection()) {
                return false;
            }
            final int autoCorrectionSuggestionScore = suggestion.mScore;
            // TODO: when the normalized score of the first suggestion is nearly equals to
            //       the normalized score of the second suggestion, behave less aggressive.
            final float normalizedScore = BinaryDictionaryUtils.calcNormalizedScore(
                    consideredWord, suggestion.mWord, autoCorrectionSuggestionScore);
            if (DBG) {
                Log.d(TAG, "Normalized " + consideredWord + "," + suggestion + ","
                        + autoCorrectionSuggestionScore + ", " + normalizedScore
                        + "(" + threshold + ")");
            }
            if (normalizedScore >= threshold) {
                if (DBG) {
                    Log.d(TAG, "Exceeds threshold.");
                }
                return true;
            }
        }
        return false;
    }
}
