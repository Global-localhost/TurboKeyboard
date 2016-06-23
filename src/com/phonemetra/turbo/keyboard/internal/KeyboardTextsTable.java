/*
 * Copyright (C) 2014 The Android Open Source Project
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

package com.phonemetra.turbo.keyboard.internal;

import java.util.HashMap;
import java.util.Locale;

public final class KeyboardTextsTable {
   
    private static final HashMap<String, Integer> sNameToIndexesMap = new HashMap<>();
    private static final HashMap<String, String[]> sLocaleToTextsTableMap = new HashMap<>();
    private static final HashMap<String[], String> sTextsTableToLocaleMap = new HashMap<>();

    public static String getText(final String name, final String[] textsTable) {
        final Integer indexObj = sNameToIndexesMap.get(name);
        if (indexObj == null) {
            throw new RuntimeException("Unknown text name=" + name + " locale="
                    + sTextsTableToLocaleMap.get(textsTable));
        }
        final int index = indexObj;
        final String text = (index < textsTable.length) ? textsTable[index] : null;
        if (text != null) {
            return text;
        }
        // Sanity check.
        if (index >= 0 && index < TEXTS_DEFAULT.length) {
            return TEXTS_DEFAULT[index];
        }
        // Throw exception for debugging purpose.
        throw new RuntimeException("Illegal index=" + index + " for name=" + name
                + " locale=" + sTextsTableToLocaleMap.get(textsTable));
    }

    public static String[] getTextsTable(final Locale locale) {
        final String localeKey = locale.toString();
        if (sLocaleToTextsTableMap.containsKey(localeKey)) {
            return sLocaleToTextsTableMap.get(localeKey);
        }
        final String languageKey = locale.getLanguage();
        if (sLocaleToTextsTableMap.containsKey(languageKey)) {
            return sLocaleToTextsTableMap.get(languageKey);
        }
        return TEXTS_DEFAULT;
    }

    private static final String[] NAMES = {
    //  /* index:histogram */ "name",
        /*   0:33 */ "morekeys_a",
        /*   1:33 */ "morekeys_o",
        /*   2:32 */ "morekeys_e",
        /*   3:31 */ "morekeys_u",
        /*   4:31 */ "keylabel_to_alpha",
        /*   5:30 */ "morekeys_i",
        /*   6:25 */ "morekeys_n",
        /*   7:25 */ "morekeys_c",
        /*   8:23 */ "double_quotes",
        /*   9:22 */ "morekeys_s",
        /*  10:22 */ "single_quotes",
        /*  11:19 */ "keyspec_currency",
        /*  12:17 */ "morekeys_y",
        /*  13:16 */ "morekeys_z",
        /*  14:14 */ "morekeys_d",
        /*  15:10 */ "morekeys_t",
        /*  16:10 */ "morekeys_l",
        /*  17:10 */ "morekeys_g",
        /*  18: 9 */ "single_angle_quotes",
        /*  19: 9 */ "double_angle_quotes",
        /*  20: 8 */ "morekeys_r",
        /*  21: 6 */ "morekeys_k",
        /*  22: 6 */ "morekeys_cyrillic_ie",
        /*  23: 5 */ "keyspec_nordic_row1_11",
        /*  24: 5 */ "keyspec_nordic_row2_10",
        /*  25: 5 */ "keyspec_nordic_row2_11",
        /*  26: 5 */ "morekeys_nordic_row2_10",
        /*  27: 5 */ "keyspec_east_slavic_row1_9",
        /*  28: 5 */ "keyspec_east_slavic_row2_2",
        /*  29: 5 */ "keyspec_east_slavic_row2_11",
        /*  30: 5 */ "keyspec_east_slavic_row3_5",
        /*  31: 5 */ "morekeys_cyrillic_soft_sign",
        /*  32: 5 */ "keyspec_symbols_1",
        /*  33: 5 */ "keyspec_symbols_2",
        /*  34: 5 */ "keyspec_symbols_3",
        /*  35: 5 */ "keyspec_symbols_4",
        /*  36: 5 */ "keyspec_symbols_5",
        /*  37: 5 */ "keyspec_symbols_6",
        /*  38: 5 */ "keyspec_symbols_7",
        /*  39: 5 */ "keyspec_symbols_8",
        /*  40: 5 */ "keyspec_symbols_9",
        /*  41: 5 */ "keyspec_symbols_0",
        /*  42: 5 */ "keylabel_to_symbol",
        /*  43: 5 */ "additional_morekeys_symbols_1",
        /*  44: 5 */ "additional_morekeys_symbols_2",
        /*  45: 5 */ "additional_morekeys_symbols_3",
        /*  46: 5 */ "additional_morekeys_symbols_4",
        /*  47: 5 */ "additional_morekeys_symbols_5",
        /*  48: 5 */ "additional_morekeys_symbols_6",
        /*  49: 5 */ "additional_morekeys_symbols_7",
        /*  50: 5 */ "additional_morekeys_symbols_8",
        /*  51: 5 */ "additional_morekeys_symbols_9",
        /*  52: 5 */ "additional_morekeys_symbols_0",
        /*  53: 5 */ "morekeys_tablet_period",
        /*  54: 4 */ "morekeys_nordic_row2_11",
        /*  55: 4 */ "morekeys_punctuation",
        /*  56: 4 */ "keyspec_tablet_comma",
        /*  57: 4 */ "keyspec_period",
        /*  58: 4 */ "morekeys_period",
        /*  59: 4 */ "keyspec_tablet_period",
        /*  60: 3 */ "keyspec_swiss_row1_11",
        /*  61: 3 */ "keyspec_swiss_row2_10",
        /*  62: 3 */ "keyspec_swiss_row2_11",
        /*  63: 3 */ "morekeys_swiss_row1_11",
        /*  64: 3 */ "morekeys_swiss_row2_10",
        /*  65: 3 */ "morekeys_swiss_row2_11",
        /*  66: 3 */ "morekeys_star",
        /*  67: 3 */ "keyspec_left_parenthesis",
        /*  68: 3 */ "keyspec_right_parenthesis",
        /*  69: 3 */ "keyspec_left_square_bracket",
        /*  70: 3 */ "keyspec_right_square_bracket",
        /*  71: 3 */ "keyspec_left_curly_bracket",
        /*  72: 3 */ "keyspec_right_curly_bracket",
        /*  73: 3 */ "keyspec_less_than",
        /*  74: 3 */ "keyspec_greater_than",
        /*  75: 3 */ "keyspec_less_than_equal",
        /*  76: 3 */ "keyspec_greater_than_equal",
        /*  77: 3 */ "keyspec_left_double_angle_quote",
        /*  78: 3 */ "keyspec_right_double_angle_quote",
        /*  79: 3 */ "keyspec_left_single_angle_quote",
        /*  80: 3 */ "keyspec_right_single_angle_quote",
        /*  81: 3 */ "keyspec_comma",
        /*  82: 3 */ "morekeys_tablet_comma",
        /*  83: 3 */ "keyhintlabel_period",
        /*  84: 3 */ "morekeys_question",
        /*  85: 2 */ "morekeys_h",
        /*  86: 2 */ "morekeys_w",
        /*  87: 2 */ "morekeys_east_slavic_row2_2",
        /*  88: 2 */ "morekeys_cyrillic_u",
        /*  89: 2 */ "morekeys_cyrillic_en",
        /*  90: 2 */ "morekeys_cyrillic_ghe",
        /*  91: 2 */ "morekeys_cyrillic_o",
        /*  92: 2 */ "morekeys_cyrillic_i",
        /*  93: 2 */ "keyspec_south_slavic_row1_6",
        /*  94: 2 */ "keyspec_south_slavic_row2_11",
        /*  95: 2 */ "keyspec_south_slavic_row3_1",
        /*  96: 2 */ "keyspec_south_slavic_row3_8",
        /*  97: 2 */ "morekeys_tablet_punctuation",
        /*  98: 2 */ "keyspec_spanish_row2_10",
        /*  99: 2 */ "morekeys_bullet",
        /* 100: 2 */ "morekeys_left_parenthesis",
        /* 101: 2 */ "morekeys_right_parenthesis",
        /* 102: 2 */ "morekeys_arabic_diacritics",
        /* 103: 2 */ "keyhintlabel_tablet_comma",
        /* 104: 2 */ "keyhintlabel_tablet_period",
        /* 105: 2 */ "keyspec_symbols_question",
        /* 106: 2 */ "keyspec_symbols_semicolon",
        /* 107: 2 */ "keyspec_symbols_percent",
        /* 108: 2 */ "morekeys_symbols_semicolon",
        /* 109: 2 */ "morekeys_symbols_percent",
        /* 110: 2 */ "label_go_key",
        /* 111: 2 */ "label_send_key",
        /* 112: 2 */ "label_next_key",
        /* 113: 2 */ "label_done_key",
        /* 114: 2 */ "label_search_key",
        /* 115: 2 */ "label_previous_key",
        /* 116: 2 */ "label_pause_key",
        /* 117: 2 */ "label_wait_key",
        /* 118: 1 */ "morekeys_v",
        /* 119: 1 */ "morekeys_j",
        /* 120: 1 */ "morekeys_q",
        /* 121: 1 */ "morekeys_x",
        /* 122: 1 */ "keyspec_q",
        /* 123: 1 */ "keyspec_w",
        /* 124: 1 */ "keyspec_y",
        /* 125: 1 */ "keyspec_x",
        /* 126: 1 */ "morekeys_east_slavic_row2_11",
        /* 127: 1 */ "morekeys_cyrillic_ka",
        /* 128: 1 */ "morekeys_cyrillic_a",
        /* 129: 1 */ "morekeys_currency_dollar",
        /* 130: 1 */ "morekeys_plus",
        /* 131: 1 */ "morekeys_less_than",
        /* 132: 1 */ "morekeys_greater_than",
        /* 133: 1 */ "morekeys_exclamation",
        /* 134: 0 */ "morekeys_currency_generic",
        /* 135: 0 */ "morekeys_symbols_1",
        /* 136: 0 */ "morekeys_symbols_2",
        /* 137: 0 */ "morekeys_symbols_3",
        /* 138: 0 */ "morekeys_symbols_4",
        /* 139: 0 */ "morekeys_symbols_5",
        /* 140: 0 */ "morekeys_symbols_6",
        /* 141: 0 */ "morekeys_symbols_7",
        /* 142: 0 */ "morekeys_symbols_8",
        /* 143: 0 */ "morekeys_symbols_9",
        /* 144: 0 */ "morekeys_symbols_0",
        /* 145: 0 */ "morekeys_am_pm",
        /* 146: 0 */ "keyspec_settings",
        /* 147: 0 */ "keyspec_shortcut",
        /* 148: 0 */ "keyspec_action_next",
        /* 149: 0 */ "keyspec_action_previous",
        /* 150: 0 */ "keylabel_to_more_symbol",
        /* 151: 0 */ "keylabel_tablet_to_more_symbol",
        /* 152: 0 */ "keylabel_to_phone_numeric",
        /* 153: 0 */ "keylabel_to_phone_symbols",
        /* 154: 0 */ "keylabel_time_am",
        /* 155: 0 */ "keylabel_time_pm",
        /* 156: 0 */ "keyspec_popular_domain",
        /* 157: 0 */ "morekeys_popular_domain",
        /* 158: 0 */ "keyspecs_left_parenthesis_more_keys",
        /* 159: 0 */ "keyspecs_right_parenthesis_more_keys",
        /* 160: 0 */ "single_laqm_raqm",
        /* 161: 0 */ "single_raqm_laqm",
        /* 162: 0 */ "double_laqm_raqm",
        /* 163: 0 */ "double_raqm_laqm",
        /* 164: 0 */ "single_lqm_rqm",
        /* 165: 0 */ "single_9qm_lqm",
        /* 166: 0 */ "single_9qm_rqm",
        /* 167: 0 */ "single_rqm_9qm",
        /* 168: 0 */ "double_lqm_rqm",
        /* 169: 0 */ "double_9qm_lqm",
        /* 170: 0 */ "double_9qm_rqm",
        /* 171: 0 */ "double_rqm_9qm",
        /* 172: 0 */ "morekeys_single_quote",
        /* 173: 0 */ "morekeys_double_quote",
        /* 174: 0 */ "morekeys_tablet_double_quote",
        /* 175: 0 */ "keyspec_emoji_action_key",
    };

    private static final String EMPTY = "";

    /* Default texts */
    private static final String[] TEXTS_DEFAULT = {
        /* morekeys_a ~ */
        EMPTY, EMPTY, EMPTY, EMPTY,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        /* keylabel_to_alpha */ "ABC",
        /* morekeys_i ~ */
        EMPTY, EMPTY, EMPTY,
        /* ~ morekeys_c */
        /* double_quotes */ "!text/double_lqm_rqm",
        /* morekeys_s */ EMPTY,
        /* single_quotes */ "!text/single_lqm_rqm",
        /* keyspec_currency */ "$",
        /* morekeys_y ~ */
        EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY,
        /* ~ morekeys_g */
        /* single_angle_quotes */ "!text/single_laqm_raqm",
        /* double_angle_quotes */ "!text/double_laqm_raqm",
        /* morekeys_r ~ */
        EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY,
        /* ~ morekeys_cyrillic_soft_sign */
        /* keyspec_symbols_1 */ "1",
        /* keyspec_symbols_2 */ "2",
        /* keyspec_symbols_3 */ "3",
        /* keyspec_symbols_4 */ "4",
        /* keyspec_symbols_5 */ "5",
        /* keyspec_symbols_6 */ "6",
        /* keyspec_symbols_7 */ "7",
        /* keyspec_symbols_8 */ "8",
        /* keyspec_symbols_9 */ "9",
        /* keyspec_symbols_0 */ "0",
        // Label for "switch to symbols" key.
        /* keylabel_to_symbol */ "?123",
        /* additional_morekeys_symbols_1 ~ */
        EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY,
        /* ~ additional_morekeys_symbols_0 */
        /* morekeys_tablet_period */ "!text/morekeys_tablet_punctuation",
        /* morekeys_nordic_row2_11 */ EMPTY,
        /* morekeys_punctuation */ "!autoColumnOrder!8,\\,,?,!,#,!text/keyspec_right_parenthesis,!text/keyspec_left_parenthesis,/,;,',@,:,-,\",+,\\%,&",
        /* keyspec_tablet_comma */ ",",
        // Period key
        /* keyspec_period */ ".",
        /* morekeys_period */ "!text/morekeys_punctuation",
        /* keyspec_tablet_period */ ".",
        /* keyspec_swiss_row1_11 ~ */
        EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY,
        /* ~ morekeys_swiss_row2_11 */
        // U+2020: "â€ " DAGGER
        // U+2021: "â€¡" DOUBLE DAGGER
        // U+2605: "â˜…" BLACK STAR
        /* morekeys_star */ "\u2020,\u2021,\u2605",
        // The all letters need to be mirrored are found at
        // http://www.unicode.org/Public/6.1.0/ucd/BidiMirroring.txt
        // U+2039: "â€¹" SINGLE LEFT-POINTING ANGLE QUOTATION MARK
        // U+203A: "â€º" SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
        // U+2264: "â‰¤" LESS-THAN OR EQUAL TO
        // U+2265: "â‰¥" GREATER-THAN EQUAL TO
        // U+00AB: "Â«" LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+00BB: "Â»" RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
        /* keyspec_left_parenthesis */ "(",
        /* keyspec_right_parenthesis */ ")",
        /* keyspec_left_square_bracket */ "[",
        /* keyspec_right_square_bracket */ "]",
        /* keyspec_left_curly_bracket */ "{",
        /* keyspec_right_curly_bracket */ "}",
        /* keyspec_less_than */ "<",
        /* keyspec_greater_than */ ">",
        /* keyspec_less_than_equal */ "\u2264",
        /* keyspec_greater_than_equal */ "\u2265",
        /* keyspec_left_double_angle_quote */ "\u00AB",
        /* keyspec_right_double_angle_quote */ "\u00BB",
        /* keyspec_left_single_angle_quote */ "\u2039",
        /* keyspec_right_single_angle_quote */ "\u203A",
        // Comma key
        /* keyspec_comma */ ",",
        /* morekeys_tablet_comma */ EMPTY,
        /* keyhintlabel_period */ EMPTY,
        // U+00BF: "Â¿" INVERTED QUESTION MARK
        /* morekeys_question */ "\u00BF",
        /* morekeys_h ~ */
        EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY,
        /* ~ keyspec_south_slavic_row3_8 */
        /* morekeys_tablet_punctuation */ "!autoColumnOrder!7,\\,,',#,!text/keyspec_right_parenthesis,!text/keyspec_left_parenthesis,/,;,@,:,-,\",+,\\%,&",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        /* keyspec_spanish_row2_10 */ "\u00F1",
        // U+266A: "â™ª" EIGHTH NOTE
        // U+2665: "â™¥" BLACK HEART SUIT
        // U+2660: "â™ " BLACK SPADE SUIT
        // U+2666: "â™¦" BLACK DIAMOND SUIT
        // U+2663: "â™£" BLACK CLUB SUIT
        /* morekeys_bullet */ "\u266A,\u2665,\u2660,\u2666,\u2663",
        /* morekeys_left_parenthesis */ "!fixedColumnOrder!3,!text/keyspecs_left_parenthesis_more_keys",
        /* morekeys_right_parenthesis */ "!fixedColumnOrder!3,!text/keyspecs_right_parenthesis_more_keys",
        /* morekeys_arabic_diacritics ~ */
        EMPTY, EMPTY, EMPTY,
        /* ~ keyhintlabel_tablet_period */
        /* keyspec_symbols_question */ "?",
        /* keyspec_symbols_semicolon */ ";",
        /* keyspec_symbols_percent */ "%",
        /* morekeys_symbols_semicolon */ EMPTY,
        // U+2030: "â€°" PER MILLE SIGN
        /* morekeys_symbols_percent */ "\u2030",
        /* label_go_key */ "!string/label_go_key",
        /* label_send_key */ "!string/label_send_key",
        /* label_next_key */ "!string/label_next_key",
        /* label_done_key */ "!string/label_done_key",
        /* label_search_key */ "!string/label_search_key",
        /* label_previous_key */ "!string/label_previous_key",
        /* label_pause_key */ "!string/label_pause_key",
        /* label_wait_key */ "!string/label_wait_key",
        /* morekeys_v ~ */
        EMPTY, EMPTY, EMPTY, EMPTY,
        /* ~ morekeys_x */
        /* keyspec_q */ "q",
        /* keyspec_w */ "w",
        /* keyspec_y */ "y",
        /* keyspec_x */ "x",
        /* morekeys_east_slavic_row2_11 ~ */
        EMPTY, EMPTY, EMPTY,
        /* ~ morekeys_cyrillic_a */
        // U+00A2: "Â¢" CENT SIGN
        // U+00A3: "Â£" POUND SIGN
        // U+20AC: "â‚¬" EURO SIGN
        // U+00A5: "Â¥" YEN SIGN
        // U+20B1: "â‚±" PESO SIGN
        /* morekeys_currency_dollar */ "\u00A2,\u00A3,\u20AC,\u00A5,\u20B1",
        // U+00B1: "Â±" PLUS-MINUS SIGN
        /* morekeys_plus */ "\u00B1",
        /* morekeys_less_than */ "!fixedColumnOrder!3,!text/keyspec_left_single_angle_quote,!text/keyspec_less_than_equal,!text/keyspec_left_double_angle_quote",
        /* morekeys_greater_than */ "!fixedColumnOrder!3,!text/keyspec_right_single_angle_quote,!text/keyspec_greater_than_equal,!text/keyspec_right_double_angle_quote",
        // U+00A1: "Â¡" INVERTED EXCLAMATION MARK
        /* morekeys_exclamation */ "\u00A1",
        /* morekeys_currency_generic */ "$,\u00A2,\u20AC,\u00A3,\u00A5,\u20B1",
        // U+00B9: "Â¹" SUPERSCRIPT ONE
        // U+00BD: "Â½" VULGAR FRACTION ONE HALF
        // U+2153: "â…“" VULGAR FRACTION ONE THIRD
        // U+00BC: "Â¼" VULGAR FRACTION ONE QUARTER
        // U+215B: "â…›" VULGAR FRACTION ONE EIGHTH
        /* morekeys_symbols_1 */ "\u00B9,\u00BD,\u2153,\u00BC,\u215B",
        // U+00B2: "Â²" SUPERSCRIPT TWO
        // U+2154: "â…”" VULGAR FRACTION TWO THIRDS
        /* morekeys_symbols_2 */ "\u00B2,\u2154",
        // U+00B3: "Â³" SUPERSCRIPT THREE
        // U+00BE: "Â¾" VULGAR FRACTION THREE QUARTERS
        // U+215C: "â…œ" VULGAR FRACTION THREE EIGHTHS
        /* morekeys_symbols_3 */ "\u00B3,\u00BE,\u215C",
        // U+2074: "â�´" SUPERSCRIPT FOUR
        /* morekeys_symbols_4 */ "\u2074",
        // U+215D: "â…�" VULGAR FRACTION FIVE EIGHTHS
        /* morekeys_symbols_5 */ "\u215D",
        /* morekeys_symbols_6 */ EMPTY,
        // U+215E: "â…ž" VULGAR FRACTION SEVEN EIGHTHS
        /* morekeys_symbols_7 */ "\u215E",
        /* morekeys_symbols_8 */ EMPTY,
        /* morekeys_symbols_9 */ EMPTY,
        // U+207F: "â�¿" SUPERSCRIPT LATIN SMALL LETTER N
        // U+2205: "âˆ…" EMPTY SET
        /* morekeys_symbols_0 */ "\u207F,\u2205",
        /* morekeys_am_pm */ "!fixedColumnOrder!2,!hasLabels!,!text/keylabel_time_am,!text/keylabel_time_pm",
        /* keyspec_settings */ "!icon/settings_key|!code/key_settings",
        /* keyspec_shortcut */ "!icon/shortcut_key|!code/key_shortcut",
        /* keyspec_action_next */ "!hasLabels!,!text/label_next_key|!code/key_action_next",
        /* keyspec_action_previous */ "!hasLabels!,!text/label_previous_key|!code/key_action_previous",
        // Label for "switch to more symbol" modifier key ("= \ <"). Must be short to fit on key!
        /* keylabel_to_more_symbol */ "= \\\\ <",
        // Label for "switch to more symbol" modifier key on tablets.  Must be short to fit on key!
        /* keylabel_tablet_to_more_symbol */ "~ [ <",
        // Label for "switch to phone numeric" key.  Must be short to fit on key!
        /* keylabel_to_phone_numeric */ "123",
        // Label for "switch to phone symbols" key.  Must be short to fit on key!
        // U+FF0A: "ï¼Š" FULLWIDTH ASTERISK
        // U+FF03: "ï¼ƒ" FULLWIDTH NUMBER SIGN
        /* keylabel_to_phone_symbols */ "\uFF0A\uFF03",
        // Key label for "ante meridiem"
        /* keylabel_time_am */ "AM",
        // Key label for "post meridiem"
        /* keylabel_time_pm */ "PM",
        /* keyspec_popular_domain */ ".com",
        // popular web domains for the locale - most popular, displayed on the keyboard
        /* morekeys_popular_domain */ "!hasLabels!,.net,.org,.gov,.edu",
        /* keyspecs_left_parenthesis_more_keys */ "!text/keyspec_less_than,!text/keyspec_left_curly_bracket,!text/keyspec_left_square_bracket",
        /* keyspecs_right_parenthesis_more_keys */ "!text/keyspec_greater_than,!text/keyspec_right_curly_bracket,!text/keyspec_right_square_bracket",
        // The following characters don't need BIDI mirroring.
        // U+2018: "â€˜" LEFT SINGLE QUOTATION MARK
        // U+2019: "â€™" RIGHT SINGLE QUOTATION MARK
        // U+201A: "â€š" SINGLE LOW-9 QUOTATION MARK
        // U+201C: "â€œ" LEFT DOUBLE QUOTATION MARK
        // U+201D: "â€�" RIGHT DOUBLE QUOTATION MARK
        // U+201E: "â€ž" DOUBLE LOW-9 QUOTATION MARK
        // Abbreviations are:
        // laqm: LEFT-POINTING ANGLE QUOTATION MARK
        // raqm: RIGHT-POINTING ANGLE QUOTATION MARK
        // lqm: LEFT QUOTATION MARK
        // rqm: RIGHT QUOTATION MARK
        // 9qm: LOW-9 QUOTATION MARK
        // The following each quotation mark pair consist of
        // <opening quotation mark>, <closing quotation mark>
        // and is named after (single|double)_<opening quotation mark>_<closing quotation mark>.
        /* single_laqm_raqm */ "!text/keyspec_left_single_angle_quote,!text/keyspec_right_single_angle_quote",
        /* single_raqm_laqm */ "!text/keyspec_right_single_angle_quote,!text/keyspec_left_single_angle_quote",
        /* double_laqm_raqm */ "!text/keyspec_left_double_angle_quote,!text/keyspec_right_double_angle_quote",
        /* double_raqm_laqm */ "!text/keyspec_right_double_angle_quote,!text/keyspec_left_double_angle_quote",
        // The following each quotation mark triplet consists of
        // <another quotation mark>, <opening quotation mark>, <closing quotation mark>
        // and is named after (single|double)_<opening quotation mark>_<closing quotation mark>.
        /* single_lqm_rqm */ "\u201A,\u2018,\u2019",
        /* single_9qm_lqm */ "\u2019,\u201A,\u2018",
        /* single_9qm_rqm */ "\u2018,\u201A,\u2019",
        /* single_rqm_9qm */ "\u2018,\u2019,\u201A",
        /* double_lqm_rqm */ "\u201E,\u201C,\u201D",
        /* double_9qm_lqm */ "\u201D,\u201E,\u201C",
        /* double_9qm_rqm */ "\u201C,\u201E,\u201D",
        /* double_rqm_9qm */ "\u201C,\u201D,\u201E",
        /* morekeys_single_quote */ "!fixedColumnOrder!5,!text/single_quotes,!text/single_angle_quotes",
        /* morekeys_double_quote */ "!fixedColumnOrder!5,!text/double_quotes,!text/double_angle_quotes",
        /* morekeys_tablet_double_quote */ "!fixedColumnOrder!6,!text/double_quotes,!text/single_quotes,!text/double_angle_quotes,!text/single_angle_quotes",
        /* keyspec_emoji_action_key */ "!icon/emoji_action_key|!code/key_emoji",
    };

    /* Locale af: Afrikaans */
    private static final String[] TEXTS_af = {
        // This is the same as Dutch except more keys of y and demoting vowels with diaeresis.
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u00E1,\u00E2,\u00E4,\u00E0,\u00E6,\u00E3,\u00E5,\u0101",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F3,\u00F4,\u00F6,\u00F2,\u00F5,\u0153,\u00F8,\u014D",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u00E8,\u00EA,\u00EB,\u0119,\u0117,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FB,\u00FC,\u00F9,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        // U+0133: "Ä³" LATIN SMALL LIGATURE IJ
        /* morekeys_i */ "\u00ED,\u00EC,\u00EF,\u00EE,\u012F,\u012B,\u0133",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u00F1,\u0144",
        /* morekeys_c ~ */
        null, null, null, null, null,
        /* ~ keyspec_currency */
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        // U+0133: "Ä³" LATIN SMALL LIGATURE IJ
        /* morekeys_y */ "\u00FD,\u0133",
    };

    /* Locale ar: Arabic */
    private static final String[] TEXTS_ar = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0623: "Ø£" ARABIC LETTER ALEF WITH HAMZA ABOVE
        // U+200C: ZERO WIDTH NON-JOINER
        // U+0628: "Ø¨" ARABIC LETTER BEH
        // U+062C: "Ø¬" ARABIC LETTER JEEM
        /* keylabel_to_alpha */ "\u0623\u200C\u0628\u200C\u062C",
        /* morekeys_i ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_cyrillic_soft_sign */
        // U+0661: "Ù¡" ARABIC-INDIC DIGIT ONE
        /* keyspec_symbols_1 */ "\u0661",
        // U+0662: "Ù¢" ARABIC-INDIC DIGIT TWO
        /* keyspec_symbols_2 */ "\u0662",
        // U+0663: "Ù£" ARABIC-INDIC DIGIT THREE
        /* keyspec_symbols_3 */ "\u0663",
        // U+0664: "Ù¤" ARABIC-INDIC DIGIT FOUR
        /* keyspec_symbols_4 */ "\u0664",
        // U+0665: "Ù¥" ARABIC-INDIC DIGIT FIVE
        /* keyspec_symbols_5 */ "\u0665",
        // U+0666: "Ù¦" ARABIC-INDIC DIGIT SIX
        /* keyspec_symbols_6 */ "\u0666",
        // U+0667: "Ù§" ARABIC-INDIC DIGIT SEVEN
        /* keyspec_symbols_7 */ "\u0667",
        // U+0668: "Ù¨" ARABIC-INDIC DIGIT EIGHT
        /* keyspec_symbols_8 */ "\u0668",
        // U+0669: "Ù©" ARABIC-INDIC DIGIT NINE
        /* keyspec_symbols_9 */ "\u0669",
        // U+0660: "Ù " ARABIC-INDIC DIGIT ZERO
        /* keyspec_symbols_0 */ "\u0660",
        // Label for "switch to symbols" key.
        // U+061F: "ØŸ" ARABIC QUESTION MARK
        /* keylabel_to_symbol */ "\u0663\u0662\u0661\u061F",
        /* additional_morekeys_symbols_1 */ "1",
        /* additional_morekeys_symbols_2 */ "2",
        /* additional_morekeys_symbols_3 */ "3",
        /* additional_morekeys_symbols_4 */ "4",
        /* additional_morekeys_symbols_5 */ "5",
        /* additional_morekeys_symbols_6 */ "6",
        /* additional_morekeys_symbols_7 */ "7",
        /* additional_morekeys_symbols_8 */ "8",
        /* additional_morekeys_symbols_9 */ "9",
        // U+066B: "Ù«" ARABIC DECIMAL SEPARATOR
        // U+066C: "Ù¬" ARABIC THOUSANDS SEPARATOR
        /* additional_morekeys_symbols_0 */ "0,\u066B,\u066C",
        /* morekeys_tablet_period */ "!text/morekeys_arabic_diacritics",
        /* morekeys_nordic_row2_11 */ null,
        /* morekeys_punctuation */ null,
        // U+061F: "ØŸ" ARABIC QUESTION MARK
        // U+060C: "ØŒ" ARABIC COMMA
        // U+061B: "Ø›" ARABIC SEMICOLON
        /* keyspec_tablet_comma */ "\u060C",
        /* keyspec_period */ null,
        /* morekeys_period */ "!text/morekeys_arabic_diacritics",
        /* keyspec_tablet_period ~ */
        null, null, null, null, null, null, null,
        /* ~ morekeys_swiss_row2_11 */
        // U+2605: "â˜…" BLACK STAR
        // U+066D: "Ù­" ARABIC FIVE POINTED STAR
        /* morekeys_star */ "\u2605,\u066D",
        // U+2264: "â‰¤" LESS-THAN OR EQUAL TO
        // U+2265: "â‰¥" GREATER-THAN EQUAL TO
        // U+00AB: "Â«" LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+00BB: "Â»" RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+2039: "â€¹" SINGLE LEFT-POINTING ANGLE QUOTATION MARK
        // U+203A: "â€º" SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
        /* keyspec_left_parenthesis */ "(|)",
        /* keyspec_right_parenthesis */ ")|(",
        /* keyspec_left_square_bracket */ "[|]",
        /* keyspec_right_square_bracket */ "]|[",
        /* keyspec_left_curly_bracket */ "{|}",
        /* keyspec_right_curly_bracket */ "}|{",
        /* keyspec_less_than */ "<|>",
        /* keyspec_greater_than */ ">|<",
        /* keyspec_less_than_equal */ "\u2264|\u2265",
        /* keyspec_greater_than_equal */ "\u2265|\u2264",
        /* keyspec_left_double_angle_quote */ "\u00AB|\u00BB",
        /* keyspec_right_double_angle_quote */ "\u00BB|\u00AB",
        /* keyspec_left_single_angle_quote */ "\u2039|\u203A",
        /* keyspec_right_single_angle_quote */ "\u203A|\u2039",
        // U+060C: "ØŒ" ARABIC COMMA
        /* keyspec_comma */ "\u060C",
        /* morekeys_tablet_comma */ "!fixedColumnOrder!4,:,!,\u061F,\u061B,-,\",\'",
        // U+0651: "Ù‘" ARABIC SHADDA
        /* keyhintlabel_period */ "\u0651",
        // U+00BF: "Â¿" INVERTED QUESTION MARK
        /* morekeys_question */ "?,\u00BF",
        /* morekeys_h ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ keyspec_spanish_row2_10 */
        // U+266A: "â™ª" EIGHTH NOTE
        /* morekeys_bullet */ "\u266A",
        // The all letters need to be mirrored are found at
        // http://www.unicode.org/Public/6.1.0/ucd/BidiMirroring.txt
        // U+FD3E: "ï´¾" ORNATE LEFT PARENTHESIS
        // U+FD3F: "ï´¿" ORNATE RIGHT PARENTHESIS
        /* morekeys_left_parenthesis */ "!fixedColumnOrder!4,\uFD3E|\uFD3F,!text/keyspecs_left_parenthesis_more_keys",
        /* morekeys_right_parenthesis */ "!fixedColumnOrder!4,\uFD3F|\uFD3E,!text/keyspecs_right_parenthesis_more_keys",
        // U+0655: "Ù•" ARABIC HAMZA BELOW
        // U+0654: "Ù”" ARABIC HAMZA ABOVE
        // U+0652: "Ù’" ARABIC SUKUN
        // U+064D: "Ù�" ARABIC KASRATAN
        // U+064C: "ÙŒ" ARABIC DAMMATAN
        // U+064B: "Ù‹" ARABIC FATHATAN
        // U+0651: "Ù‘" ARABIC SHADDA
        // U+0656: "Ù–" ARABIC SUBSCRIPT ALEF
        // U+0670: "Ù°" ARABIC LETTER SUPERSCRIPT ALEF
        // U+0653: "Ù“" ARABIC MADDAH ABOVE
        // U+0650: "Ù�" ARABIC KASRA
        // U+064F: "Ù�" ARABIC DAMMA
        // U+064E: "ÙŽ" ARABIC FATHA
        // U+0640: "Ù€" ARABIC TATWEEL
        // In order to make Tatweel easily distinguishable from other punctuations, we use consecutive Tatweels only for its displayed label.
        // Note: The space character is needed as a preceding letter to draw Arabic diacritics characters correctly.
        /* morekeys_arabic_diacritics */ "!fixedColumnOrder!7, \u0655|\u0655, \u0654|\u0654, \u0652|\u0652, \u064D|\u064D, \u064C|\u064C, \u064B|\u064B, \u0651|\u0651, \u0656|\u0656, \u0670|\u0670, \u0653|\u0653, \u0650|\u0650, \u064F|\u064F, \u064E|\u064E,\u0640\u0640\u0640|\u0640",
        /* keyhintlabel_tablet_comma */ "\u061F",
        /* keyhintlabel_tablet_period */ "\u0651",
        /* keyspec_symbols_question */ "\u061F",
        /* keyspec_symbols_semicolon */ "\u061B",
        // U+066A: "Ùª" ARABIC PERCENT SIGN
        /* keyspec_symbols_percent */ "\u066A",
        /* morekeys_symbols_semicolon */ ";",
        // U+2030: "â€°" PER MILLE SIGN
        /* morekeys_symbols_percent */ "\\%,\u2030",
    };
    
    /* Locale ar-AE: Arabic (UAE)  */
    private static final String[] TEXTS_ar_AE = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0623: "Ø£" ARABIC LETTER ALEF WITH HAMZA ABOVE
        // U+200C: ZERO WIDTH NON-JOINER
        // U+0628: "Ø¨" ARABIC LETTER BEH
        // U+062C: "Ø¬" ARABIC LETTER JEEM
        /* keylabel_to_alpha */ "\u0623\u200C\u0628\u200C\u062C",
        /* morekeys_i ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_cyrillic_soft_sign */
        // U+0661: "Ù¡" ARABIC-INDIC DIGIT ONE
        /* keyspec_symbols_1 */ "\u0661",
        // U+0662: "Ù¢" ARABIC-INDIC DIGIT TWO
        /* keyspec_symbols_2 */ "\u0662",
        // U+0663: "Ù£" ARABIC-INDIC DIGIT THREE
        /* keyspec_symbols_3 */ "\u0663",
        // U+0664: "Ù¤" ARABIC-INDIC DIGIT FOUR
        /* keyspec_symbols_4 */ "\u0664",
        // U+0665: "Ù¥" ARABIC-INDIC DIGIT FIVE
        /* keyspec_symbols_5 */ "\u0665",
        // U+0666: "Ù¦" ARABIC-INDIC DIGIT SIX
        /* keyspec_symbols_6 */ "\u0666",
        // U+0667: "Ù§" ARABIC-INDIC DIGIT SEVEN
        /* keyspec_symbols_7 */ "\u0667",
        // U+0668: "Ù¨" ARABIC-INDIC DIGIT EIGHT
        /* keyspec_symbols_8 */ "\u0668",
        // U+0669: "Ù©" ARABIC-INDIC DIGIT NINE
        /* keyspec_symbols_9 */ "\u0669",
        // U+0660: "Ù " ARABIC-INDIC DIGIT ZERO
        /* keyspec_symbols_0 */ "\u0660",
        // Label for "switch to symbols" key.
        // U+061F: "ØŸ" ARABIC QUESTION MARK
        /* keylabel_to_symbol */ "\u0663\u0662\u0661\u061F",
        /* additional_morekeys_symbols_1 */ "1",
        /* additional_morekeys_symbols_2 */ "2",
        /* additional_morekeys_symbols_3 */ "3",
        /* additional_morekeys_symbols_4 */ "4",
        /* additional_morekeys_symbols_5 */ "5",
        /* additional_morekeys_symbols_6 */ "6",
        /* additional_morekeys_symbols_7 */ "7",
        /* additional_morekeys_symbols_8 */ "8",
        /* additional_morekeys_symbols_9 */ "9",
        // U+066B: "Ù«" ARABIC DECIMAL SEPARATOR
        // U+066C: "Ù¬" ARABIC THOUSANDS SEPARATOR
        /* additional_morekeys_symbols_0 */ "0,\u066B,\u066C",
        /* morekeys_tablet_period */ "!text/morekeys_arabic_diacritics",
        /* morekeys_nordic_row2_11 */ null,
        /* morekeys_punctuation */ null,
        // U+061F: "ØŸ" ARABIC QUESTION MARK
        // U+060C: "ØŒ" ARABIC COMMA
        // U+061B: "Ø›" ARABIC SEMICOLON
        /* keyspec_tablet_comma */ "\u060C",
        /* keyspec_period */ null,
        /* morekeys_period */ "!text/morekeys_arabic_diacritics",
        /* keyspec_tablet_period ~ */
        null, null, null, null, null, null, null,
        /* ~ morekeys_swiss_row2_11 */
        // U+2605: "â˜…" BLACK STAR
        // U+066D: "Ù­" ARABIC FIVE POINTED STAR
        /* morekeys_star */ "\u2605,\u066D",
        // U+2264: "â‰¤" LESS-THAN OR EQUAL TO
        // U+2265: "â‰¥" GREATER-THAN EQUAL TO
        // U+00AB: "Â«" LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+00BB: "Â»" RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+2039: "â€¹" SINGLE LEFT-POINTING ANGLE QUOTATION MARK
        // U+203A: "â€º" SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
        /* keyspec_left_parenthesis */ "(|)",
        /* keyspec_right_parenthesis */ ")|(",
        /* keyspec_left_square_bracket */ "[|]",
        /* keyspec_right_square_bracket */ "]|[",
        /* keyspec_left_curly_bracket */ "{|}",
        /* keyspec_right_curly_bracket */ "}|{",
        /* keyspec_less_than */ "<|>",
        /* keyspec_greater_than */ ">|<",
        /* keyspec_less_than_equal */ "\u2264|\u2265",
        /* keyspec_greater_than_equal */ "\u2265|\u2264",
        /* keyspec_left_double_angle_quote */ "\u00AB|\u00BB",
        /* keyspec_right_double_angle_quote */ "\u00BB|\u00AB",
        /* keyspec_left_single_angle_quote */ "\u2039|\u203A",
        /* keyspec_right_single_angle_quote */ "\u203A|\u2039",
        // U+060C: "ØŒ" ARABIC COMMA
        /* keyspec_comma */ "\u060C",
        /* morekeys_tablet_comma */ "!fixedColumnOrder!4,:,!,\u061F,\u061B,-,\",\'",
        // U+0651: "Ù‘" ARABIC SHADDA
        /* keyhintlabel_period */ "\u0651",
        // U+00BF: "Â¿" INVERTED QUESTION MARK
        /* morekeys_question */ "?,\u00BF",
        /* morekeys_h ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ keyspec_spanish_row2_10 */
        // U+266A: "â™ª" EIGHTH NOTE
        /* morekeys_bullet */ "\u266A",
        // The all letters need to be mirrored are found at
        // http://www.unicode.org/Public/6.1.0/ucd/BidiMirroring.txt
        // U+FD3E: "ï´¾" ORNATE LEFT PARENTHESIS
        // U+FD3F: "ï´¿" ORNATE RIGHT PARENTHESIS
        /* morekeys_left_parenthesis */ "!fixedColumnOrder!4,\uFD3E|\uFD3F,!text/keyspecs_left_parenthesis_more_keys",
        /* morekeys_right_parenthesis */ "!fixedColumnOrder!4,\uFD3F|\uFD3E,!text/keyspecs_right_parenthesis_more_keys",
        // U+0655: "Ù•" ARABIC HAMZA BELOW
        // U+0654: "Ù”" ARABIC HAMZA ABOVE
        // U+0652: "Ù’" ARABIC SUKUN
        // U+064D: "Ù�" ARABIC KASRATAN
        // U+064C: "ÙŒ" ARABIC DAMMATAN
        // U+064B: "Ù‹" ARABIC FATHATAN
        // U+0651: "Ù‘" ARABIC SHADDA
        // U+0656: "Ù–" ARABIC SUBSCRIPT ALEF
        // U+0670: "Ù°" ARABIC LETTER SUPERSCRIPT ALEF
        // U+0653: "Ù“" ARABIC MADDAH ABOVE
        // U+0650: "Ù�" ARABIC KASRA
        // U+064F: "Ù�" ARABIC DAMMA
        // U+064E: "ÙŽ" ARABIC FATHA
        // U+0640: "Ù€" ARABIC TATWEEL
        // In order to make Tatweel easily distinguishable from other punctuations, we use consecutive Tatweels only for its displayed label.
        // Note: The space character is needed as a preceding letter to draw Arabic diacritics characters correctly.
        /* morekeys_arabic_diacritics */ "!fixedColumnOrder!7, \u0655|\u0655, \u0654|\u0654, \u0652|\u0652, \u064D|\u064D, \u064C|\u064C, \u064B|\u064B, \u0651|\u0651, \u0656|\u0656, \u0670|\u0670, \u0653|\u0653, \u0650|\u0650, \u064F|\u064F, \u064E|\u064E,\u0640\u0640\u0640|\u0640",
        /* keyhintlabel_tablet_comma */ "\u061F",
        /* keyhintlabel_tablet_period */ "\u0651",
        /* keyspec_symbols_question */ "\u061F",
        /* keyspec_symbols_semicolon */ "\u061B",
        // U+066A: "Ùª" ARABIC PERCENT SIGN
        /* keyspec_symbols_percent */ "\u066A",
        /* morekeys_symbols_semicolon */ ";",
        // U+2030: "â€°" PER MILLE SIGN
        /* morekeys_symbols_percent */ "\\%,\u2030",
    };
    
    /* Locale ar-QA: Arabic (Qatar)  */
    private static final String[] TEXTS_ar_QA = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0623: "Ø£" ARABIC LETTER ALEF WITH HAMZA ABOVE
        // U+200C: ZERO WIDTH NON-JOINER
        // U+0628: "Ø¨" ARABIC LETTER BEH
        // U+062C: "Ø¬" ARABIC LETTER JEEM
        /* keylabel_to_alpha */ "\u0623\u200C\u0628\u200C\u062C",
        /* morekeys_i ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_cyrillic_soft_sign */
        // U+0661: "Ù¡" ARABIC-INDIC DIGIT ONE
        /* keyspec_symbols_1 */ "\u0661",
        // U+0662: "Ù¢" ARABIC-INDIC DIGIT TWO
        /* keyspec_symbols_2 */ "\u0662",
        // U+0663: "Ù£" ARABIC-INDIC DIGIT THREE
        /* keyspec_symbols_3 */ "\u0663",
        // U+0664: "Ù¤" ARABIC-INDIC DIGIT FOUR
        /* keyspec_symbols_4 */ "\u0664",
        // U+0665: "Ù¥" ARABIC-INDIC DIGIT FIVE
        /* keyspec_symbols_5 */ "\u0665",
        // U+0666: "Ù¦" ARABIC-INDIC DIGIT SIX
        /* keyspec_symbols_6 */ "\u0666",
        // U+0667: "Ù§" ARABIC-INDIC DIGIT SEVEN
        /* keyspec_symbols_7 */ "\u0667",
        // U+0668: "Ù¨" ARABIC-INDIC DIGIT EIGHT
        /* keyspec_symbols_8 */ "\u0668",
        // U+0669: "Ù©" ARABIC-INDIC DIGIT NINE
        /* keyspec_symbols_9 */ "\u0669",
        // U+0660: "Ù " ARABIC-INDIC DIGIT ZERO
        /* keyspec_symbols_0 */ "\u0660",
        // Label for "switch to symbols" key.
        // U+061F: "ØŸ" ARABIC QUESTION MARK
        /* keylabel_to_symbol */ "\u0663\u0662\u0661\u061F",
        /* additional_morekeys_symbols_1 */ "1",
        /* additional_morekeys_symbols_2 */ "2",
        /* additional_morekeys_symbols_3 */ "3",
        /* additional_morekeys_symbols_4 */ "4",
        /* additional_morekeys_symbols_5 */ "5",
        /* additional_morekeys_symbols_6 */ "6",
        /* additional_morekeys_symbols_7 */ "7",
        /* additional_morekeys_symbols_8 */ "8",
        /* additional_morekeys_symbols_9 */ "9",
        // U+066B: "Ù«" ARABIC DECIMAL SEPARATOR
        // U+066C: "Ù¬" ARABIC THOUSANDS SEPARATOR
        /* additional_morekeys_symbols_0 */ "0,\u066B,\u066C",
        /* morekeys_tablet_period */ "!text/morekeys_arabic_diacritics",
        /* morekeys_nordic_row2_11 */ null,
        /* morekeys_punctuation */ null,
        // U+061F: "ØŸ" ARABIC QUESTION MARK
        // U+060C: "ØŒ" ARABIC COMMA
        // U+061B: "Ø›" ARABIC SEMICOLON
        /* keyspec_tablet_comma */ "\u060C",
        /* keyspec_period */ null,
        /* morekeys_period */ "!text/morekeys_arabic_diacritics",
        /* keyspec_tablet_period ~ */
        null, null, null, null, null, null, null,
        /* ~ morekeys_swiss_row2_11 */
        // U+2605: "â˜…" BLACK STAR
        // U+066D: "Ù­" ARABIC FIVE POINTED STAR
        /* morekeys_star */ "\u2605,\u066D",
        // U+2264: "â‰¤" LESS-THAN OR EQUAL TO
        // U+2265: "â‰¥" GREATER-THAN EQUAL TO
        // U+00AB: "Â«" LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+00BB: "Â»" RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+2039: "â€¹" SINGLE LEFT-POINTING ANGLE QUOTATION MARK
        // U+203A: "â€º" SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
        /* keyspec_left_parenthesis */ "(|)",
        /* keyspec_right_parenthesis */ ")|(",
        /* keyspec_left_square_bracket */ "[|]",
        /* keyspec_right_square_bracket */ "]|[",
        /* keyspec_left_curly_bracket */ "{|}",
        /* keyspec_right_curly_bracket */ "}|{",
        /* keyspec_less_than */ "<|>",
        /* keyspec_greater_than */ ">|<",
        /* keyspec_less_than_equal */ "\u2264|\u2265",
        /* keyspec_greater_than_equal */ "\u2265|\u2264",
        /* keyspec_left_double_angle_quote */ "\u00AB|\u00BB",
        /* keyspec_right_double_angle_quote */ "\u00BB|\u00AB",
        /* keyspec_left_single_angle_quote */ "\u2039|\u203A",
        /* keyspec_right_single_angle_quote */ "\u203A|\u2039",
        // U+060C: "ØŒ" ARABIC COMMA
        /* keyspec_comma */ "\u060C",
        /* morekeys_tablet_comma */ "!fixedColumnOrder!4,:,!,\u061F,\u061B,-,\",\'",
        // U+0651: "Ù‘" ARABIC SHADDA
        /* keyhintlabel_period */ "\u0651",
        // U+00BF: "Â¿" INVERTED QUESTION MARK
        /* morekeys_question */ "?,\u00BF",
        /* morekeys_h ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ keyspec_spanish_row2_10 */
        // U+266A: "â™ª" EIGHTH NOTE
        /* morekeys_bullet */ "\u266A",
        // The all letters need to be mirrored are found at
        // http://www.unicode.org/Public/6.1.0/ucd/BidiMirroring.txt
        // U+FD3E: "ï´¾" ORNATE LEFT PARENTHESIS
        // U+FD3F: "ï´¿" ORNATE RIGHT PARENTHESIS
        /* morekeys_left_parenthesis */ "!fixedColumnOrder!4,\uFD3E|\uFD3F,!text/keyspecs_left_parenthesis_more_keys",
        /* morekeys_right_parenthesis */ "!fixedColumnOrder!4,\uFD3F|\uFD3E,!text/keyspecs_right_parenthesis_more_keys",
        // U+0655: "Ù•" ARABIC HAMZA BELOW
        // U+0654: "Ù”" ARABIC HAMZA ABOVE
        // U+0652: "Ù’" ARABIC SUKUN
        // U+064D: "Ù�" ARABIC KASRATAN
        // U+064C: "ÙŒ" ARABIC DAMMATAN
        // U+064B: "Ù‹" ARABIC FATHATAN
        // U+0651: "Ù‘" ARABIC SHADDA
        // U+0656: "Ù–" ARABIC SUBSCRIPT ALEF
        // U+0670: "Ù°" ARABIC LETTER SUPERSCRIPT ALEF
        // U+0653: "Ù“" ARABIC MADDAH ABOVE
        // U+0650: "Ù�" ARABIC KASRA
        // U+064F: "Ù�" ARABIC DAMMA
        // U+064E: "ÙŽ" ARABIC FATHA
        // U+0640: "Ù€" ARABIC TATWEEL
        // In order to make Tatweel easily distinguishable from other punctuations, we use consecutive Tatweels only for its displayed label.
        // Note: The space character is needed as a preceding letter to draw Arabic diacritics characters correctly.
        /* morekeys_arabic_diacritics */ "!fixedColumnOrder!7, \u0655|\u0655, \u0654|\u0654, \u0652|\u0652, \u064D|\u064D, \u064C|\u064C, \u064B|\u064B, \u0651|\u0651, \u0656|\u0656, \u0670|\u0670, \u0653|\u0653, \u0650|\u0650, \u064F|\u064F, \u064E|\u064E,\u0640\u0640\u0640|\u0640",
        /* keyhintlabel_tablet_comma */ "\u061F",
        /* keyhintlabel_tablet_period */ "\u0651",
        /* keyspec_symbols_question */ "\u061F",
        /* keyspec_symbols_semicolon */ "\u061B",
        // U+066A: "Ùª" ARABIC PERCENT SIGN
        /* keyspec_symbols_percent */ "\u066A",
        /* morekeys_symbols_semicolon */ ";",
        // U+2030: "â€°" PER MILLE SIGN
        /* morekeys_symbols_percent */ "\\%,\u2030",
    };

    /* Locale az_AZ: Azerbaijani (Azerbaijan) */
    private static final String[] TEXTS_az_AZ = {
        // This is the same as Turkish
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        /* morekeys_a */ "\u00E2,\u00E4,\u00E1",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F6,\u00F4,\u0153,\u00F2,\u00F3,\u00F5,\u00F8,\u014D",
        // U+0259: "É™" LATIN SMALL LETTER SCHWA
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        /* morekeys_e */ "\u0259,\u00E9",
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FC,\u00FB,\u00F9,\u00FA,\u016B",
        /* keylabel_to_alpha */ null,
        // U+0131: "Ä±" LATIN SMALL LETTER DOTLESS I
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u0131,\u00EE,\u00EF,\u00EC,\u00ED,\u012F,\u012B",
        // U+0148: "Åˆ" LATIN SMALL LETTER N WITH CARON
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        /* morekeys_n */ "\u0148,\u00F1",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        /* morekeys_c */ "\u00E7,\u0107,\u010D",
        /* double_quotes */ null,
        // U+015F: "ÅŸ" LATIN SMALL LETTER S WITH CEDILLA
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        /* morekeys_s */ "\u015F,\u00DF,\u015B,\u0161",
        /* single_quotes */ null,
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        /* morekeys_y */ "\u00FD",
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        /* morekeys_z */ "\u017E",
        /* morekeys_d ~ */
        null, null, null,
        /* ~ morekeys_l */
        // U+011F: "ÄŸ" LATIN SMALL LETTER G WITH BREVE
        /* morekeys_g */ "\u011F",
    };

    /* Locale be_BY: Belarusian (Belarus) */
    private static final String[] TEXTS_be_BY = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0410: "Ð�" CYRILLIC CAPITAL LETTER A
        // U+0411: "Ð‘" CYRILLIC CAPITAL LETTER BE
        // U+0412: "Ð’" CYRILLIC CAPITAL LETTER VE
        /* keylabel_to_alpha */ "\u0410\u0411\u0412",
        /* morekeys_i ~ */
        null, null, null,
        /* ~ morekeys_c */
        /* double_quotes */ "!text/double_9qm_lqm",
        /* morekeys_s */ null,
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency ~ */
        null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_k */
        // U+0451: "Ñ‘" CYRILLIC SMALL LETTER IO
        /* morekeys_cyrillic_ie */ "\u0451",
        /* keyspec_nordic_row1_11 ~ */
        null, null, null, null,
        /* ~ morekeys_nordic_row2_10 */
        // U+045E: "Ñž" CYRILLIC SMALL LETTER SHORT U
        /* keyspec_east_slavic_row1_9 */ "\u045E",
        // U+044B: "Ñ‹" CYRILLIC SMALL LETTER YERU
        /* keyspec_east_slavic_row2_2 */ "\u044B",
        // U+044D: "Ñ�" CYRILLIC SMALL LETTER E
        /* keyspec_east_slavic_row2_11 */ "\u044D",
        // U+0456: "Ñ–" CYRILLIC SMALL LETTER BYELORUSSIAN-UKRAINIAN I
        /* keyspec_east_slavic_row3_5 */ "\u0456",
        // U+044A: "ÑŠ" CYRILLIC SMALL LETTER HARD SIGN
        /* morekeys_cyrillic_soft_sign */ "\u044A",
    };

    /* Locale bg: Bulgarian */
    private static final String[] TEXTS_bg = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0410: "Ð�" CYRILLIC CAPITAL LETTER A
        // U+0411: "Ð‘" CYRILLIC CAPITAL LETTER BE
        // U+0412: "Ð’" CYRILLIC CAPITAL LETTER VE
        /* keylabel_to_alpha */ "\u0410\u0411\u0412",
        /* morekeys_i ~ */
        null, null, null,
        /* ~ morekeys_c */
        // single_quotes of Bulgarian is default single_quotes_right_left.
        /* double_quotes */ "!text/double_9qm_lqm",
    };

    /* Locale bn_BD: Bengali (Bangladesh) */
    private static final String[] TEXTS_bn_BD = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0995: "à¤•" BENGALI LETTER KA
        // U+0996: "à¤–" BENGALI LETTER KHA
        // U+0997: "à¤—" BENGALI LETTER GA
        /* keylabel_to_alpha */ "\u0995\u0996\u0997",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+09F3: "à§³" BENGALI RUPEE SIGN
        /* keyspec_currency */ "\u09F3",
    };

    /* Locale bn_IN: Bengali (India) */
    private static final String[] TEXTS_bn_IN = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0995: "à¤•" BENGALI LETTER KA
        // U+0996: "à¤–" BENGALI LETTER KHA
        // U+0997: "à¤—" BENGALI LETTER GA
        /* keylabel_to_alpha */ "\u0995\u0996\u0997",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+20B9: "â‚¹" INDIAN RUPEE SIGN
        /* keyspec_currency */ "\u20B9",
    };

    /* Locale ca: Catalan */
    private static final String[] TEXTS_ca = {
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+00AA: "Âª" FEMININE ORDINAL INDICATOR
        /* morekeys_a */ "\u00E0,\u00E1,\u00E4,\u00E2,\u00E3,\u00E5,\u0105,\u00E6,\u0101,\u00AA",
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+00BA: "Âº" MASCULINE ORDINAL INDICATOR
        /* morekeys_o */ "\u00F2,\u00F3,\u00F6,\u00F4,\u00F5,\u00F8,\u0153,\u014D,\u00BA",
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E8,\u00E9,\u00EB,\u00EA,\u0119,\u0117,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FC,\u00F9,\u00FB,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u00ED,\u00EF,\u00EC,\u00EE,\u012F,\u012B",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u00F1,\u0144",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        /* morekeys_c */ "\u00E7,\u0107,\u010D",
        /* double_quotes ~ */
        null, null, null, null, null, null, null, null,
        /* ~ morekeys_t */
        // U+00B7: "Â·" MIDDLE DOT
        // U+0142: "Å‚" LATIN SMALL LETTER L WITH STROKE
        /* morekeys_l */ "l\u00B7l,\u0142",
        /* morekeys_g ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null,
        /* ~ morekeys_nordic_row2_11 */
        // U+00B7: "Â·" MIDDLE DOT
        /* morekeys_punctuation */ "!autoColumnOrder!9,\\,,?,!,\u00B7,#,),(,/,;,',@,:,-,\",+,\\%,&",
        /* keyspec_tablet_comma ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null,
        /* ~ keyspec_south_slavic_row3_8 */
        /* morekeys_tablet_punctuation */ "!autoColumnOrder!8,\\,,',\u00B7,#,),(,/,;,@,:,-,\",+,\\%,&",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        /* keyspec_spanish_row2_10 */ "\u00E7",
    };

    /* Locale cs: Czech */
    private static final String[] TEXTS_cs = {
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u00E1,\u00E0,\u00E2,\u00E4,\u00E6,\u00E3,\u00E5,\u0101",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F3,\u00F6,\u00F4,\u00F2,\u00F5,\u0153,\u00F8,\u014D",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+011B: "Ä›" LATIN SMALL LETTER E WITH CARON
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u011B,\u00E8,\u00EA,\u00EB,\u0119,\u0117,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+016F: "Å¯" LATIN SMALL LETTER U WITH RING ABOVE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u016F,\u00FB,\u00FC,\u00F9,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u00ED,\u00EE,\u00EF,\u00EC,\u012F,\u012B",
        // U+0148: "Åˆ" LATIN SMALL LETTER N WITH CARON
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u0148,\u00F1,\u0144",
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        /* morekeys_c */ "\u010D,\u00E7,\u0107",
        /* double_quotes */ "!text/double_9qm_lqm",
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        /* morekeys_s */ "\u0161,\u00DF,\u015B",
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        // U+00FF: "Ã¿" LATIN SMALL LETTER Y WITH DIAERESIS
        /* morekeys_y */ "\u00FD,\u00FF",
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        // U+017A: "Åº" LATIN SMALL LETTER Z WITH ACUTE
        // U+017C: "Å¼" LATIN SMALL LETTER Z WITH DOT ABOVE
        /* morekeys_z */ "\u017E,\u017A,\u017C",
        // U+010F: "Ä�" LATIN SMALL LETTER D WITH CARON
        /* morekeys_d */ "\u010F",
        // U+0165: "Å¥" LATIN SMALL LETTER T WITH CARON
        /* morekeys_t */ "\u0165",
        /* morekeys_l */ null,
        /* morekeys_g */ null,
        /* single_angle_quotes */ "!text/single_raqm_laqm",
        /* double_angle_quotes */ "!text/double_raqm_laqm",
        // U+0159: "Å™" LATIN SMALL LETTER R WITH CARON
        /* morekeys_r */ "\u0159",
    };

    /* Locale da: Danish */
    private static final String[] TEXTS_da = {
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u00E5,\u00E6,\u00E1,\u00E4,\u00E0,\u00E2,\u00E3,\u0101",
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F8,\u00F6,\u00F3,\u00F4,\u00F2,\u00F5,\u0153,\u014D",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        /* morekeys_e */ "\u00E9,\u00EB",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FC,\u00FB,\u00F9,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        /* morekeys_i */ "\u00ED,\u00EF",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u00F1,\u0144",
        /* morekeys_c */ null,
        /* double_quotes */ "!text/double_9qm_lqm",
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        /* morekeys_s */ "\u00DF,\u015B,\u0161",
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        // U+00FF: "Ã¿" LATIN SMALL LETTER Y WITH DIAERESIS
        /* morekeys_y */ "\u00FD,\u00FF",
        /* morekeys_z */ null,
        // U+00F0: "Ã°" LATIN SMALL LETTER ETH
        /* morekeys_d */ "\u00F0",
        /* morekeys_t */ null,
        // U+0142: "Å‚" LATIN SMALL LETTER L WITH STROKE
        /* morekeys_l */ "\u0142",
        /* morekeys_g */ null,
        /* single_angle_quotes */ "!text/single_raqm_laqm",
        /* double_angle_quotes */ "!text/double_raqm_laqm",
        /* morekeys_r ~ */
        null, null, null,
        /* ~ morekeys_cyrillic_ie */
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        /* keyspec_nordic_row1_11 */ "\u00E5",
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        /* keyspec_nordic_row2_10 */ "\u00E6",
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        /* keyspec_nordic_row2_11 */ "\u00F8",
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        /* morekeys_nordic_row2_10 */ "\u00E4",
        /* keyspec_east_slavic_row1_9 ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_tablet_period */
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        /* morekeys_nordic_row2_11 */ "\u00F6",
    };

    /* Locale de: German */
    private static final String[] TEXTS_de = {
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u00E4,%,\u00E2,\u00E0,\u00E1,\u00E6,\u00E3,\u00E5,\u0101",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F6,%,\u00F4,\u00F2,\u00F3,\u00F5,\u0153,\u00F8,\u014D",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        /* morekeys_e */ "\u00E9,\u00E8,\u00EA,\u00EB,\u0117",
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FC,%,\u00FB,\u00F9,\u00FA,\u016B",
        /* keylabel_to_alpha */ null,
        /* morekeys_i */ null,
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u00F1,\u0144",
        /* morekeys_c */ null,
        /* double_quotes */ "!text/double_9qm_lqm",
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        /* morekeys_s */ "\u00DF,\u015B,\u0161",
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency ~ */
        null, null, null, null, null, null, null,
        /* ~ morekeys_g */
        /* single_angle_quotes */ "!text/single_raqm_laqm",
        /* double_angle_quotes */ "!text/double_raqm_laqm",
        /* morekeys_r ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null,
        /* ~ keyspec_tablet_period */
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        /* keyspec_swiss_row1_11 */ "\u00FC",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        /* keyspec_swiss_row2_10 */ "\u00F6",
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        /* keyspec_swiss_row2_11 */ "\u00E4",
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        /* morekeys_swiss_row1_11 */ "\u00E8",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        /* morekeys_swiss_row2_10 */ "\u00E9",
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        /* morekeys_swiss_row2_11 */ "\u00E0",
    };

    /* Locale el: Greek */
    private static final String[] TEXTS_el = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0391: "Î‘" GREEK CAPITAL LETTER ALPHA
        // U+0392: "Î’" GREEK CAPITAL LETTER BETA
        // U+0393: "Î“" GREEK CAPITAL LETTER GAMMA
        /* keylabel_to_alpha */ "\u0391\u0392\u0393",
    };

    /* Locale en: English */
    private static final String[] TEXTS_en = {
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u00E0,\u00E1,\u00E2,\u00E4,\u00E6,\u00E3,\u00E5,\u0101",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        /* morekeys_o */ "\u00F3,\u00F4,\u00F6,\u00F2,\u0153,\u00F8,\u014D,\u00F5",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u00E8,\u00EA,\u00EB,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FB,\u00FC,\u00F9,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        /* morekeys_i */ "\u00ED,\u00EE,\u00EF,\u012B,\u00EC",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        /* morekeys_n */ "\u00F1",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        /* morekeys_c */ "\u00E7",
        /* double_quotes */ null,
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        /* morekeys_s */ "\u00DF",
    };

    /* Locale eo: Esperanto */
    private static final String[] TEXTS_eo = {
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+0103: "Äƒ" LATIN SMALL LETTER A WITH BREVE
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        // U+00AA: "Âª" FEMININE ORDINAL INDICATOR
        /* morekeys_a */ "\u00E1,\u00E0,\u00E2,\u00E4,\u00E6,\u00E3,\u00E5,\u0101,\u0103,\u0105,\u00AA",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+0151: "Å‘" LATIN SMALL LETTER O WITH DOUBLE ACUTE
        // U+00BA: "Âº" MASCULINE ORDINAL INDICATOR
        /* morekeys_o */ "\u00F3,\u00F6,\u00F4,\u00F2,\u00F5,\u0153,\u00F8,\u014D,\u0151,\u00BA",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+011B: "Ä›" LATIN SMALL LETTER E WITH CARON
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u011B,\u00E8,\u00EA,\u00EB,\u0119,\u0117,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+016F: "Å¯" LATIN SMALL LETTER U WITH RING ABOVE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        // U+0169: "Å©" LATIN SMALL LETTER U WITH TILDE
        // U+0171: "Å±" LATIN SMALL LETTER U WITH DOUBLE ACUTE
        // U+0173: "Å³" LATIN SMALL LETTER U WITH OGONEK
        // U+00B5: "Âµ" MICRO SIGN
        /* morekeys_u */ "\u00FA,\u016F,\u00FB,\u00FC,\u00F9,\u016B,\u0169,\u0171,\u0173,\u00B5",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+0129: "Ä©" LATIN SMALL LETTER I WITH TILDE
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        // U+0131: "Ä±" LATIN SMALL LETTER DOTLESS I
        // U+0133: "Ä³" LATIN SMALL LIGATURE IJ
        /* morekeys_i */ "\u00ED,\u00EE,\u00EF,\u0129,\u00EC,\u012F,\u012B,\u0131,\u0133",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        // U+0146: "Å†" LATIN SMALL LETTER N WITH CEDILLA
        // U+0148: "Åˆ" LATIN SMALL LETTER N WITH CARON
        // U+0149: "Å‰" LATIN SMALL LETTER N PRECEDED BY APOSTROPHE
        // U+014B: "Å‹" LATIN SMALL LETTER ENG
        /* morekeys_n */ "\u00F1,\u0144,\u0146,\u0148,\u0149,\u014B",
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+010B: "Ä‹" LATIN SMALL LETTER C WITH DOT ABOVE
        /* morekeys_c */ "\u0107,\u010D,\u00E7,\u010B",
        /* double_quotes */ null,
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+0219: "È™" LATIN SMALL LETTER S WITH COMMA BELOW
        // U+015F: "ÅŸ" LATIN SMALL LETTER S WITH CEDILLA
        /* morekeys_s */ "\u00DF,\u0161,\u015B,\u0219,\u015F",
        /* single_quotes */ null,
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        // U+0177: "Å·" LATIN SMALL LETTER Y WITH CIRCUMFLEX
        // U+00FF: "Ã¿" LATIN SMALL LETTER Y WITH DIAERESIS
        // U+00FE: "Ã¾" LATIN SMALL LETTER THORN
        /* morekeys_y */ "y,\u00FD,\u0177,\u00FF,\u00FE",
        // U+017A: "Åº" LATIN SMALL LETTER Z WITH ACUTE
        // U+017C: "Å¼" LATIN SMALL LETTER Z WITH DOT ABOVE
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        /* morekeys_z */ "\u017A,\u017C,\u017E",
        // U+00F0: "Ã°" LATIN SMALL LETTER ETH
        // U+010F: "Ä�" LATIN SMALL LETTER D WITH CARON
        // U+0111: "Ä‘" LATIN SMALL LETTER D WITH STROKE
        /* morekeys_d */ "\u00F0,\u010F,\u0111",
        // U+0165: "Å¥" LATIN SMALL LETTER T WITH CARON
        // U+021B: "È›" LATIN SMALL LETTER T WITH COMMA BELOW
        // U+0163: "Å£" LATIN SMALL LETTER T WITH CEDILLA
        // U+0167: "Å§" LATIN SMALL LETTER T WITH STROKE
        /* morekeys_t */ "\u0165,\u021B,\u0163,\u0167",
        // U+013A: "Äº" LATIN SMALL LETTER L WITH ACUTE
        // U+013C: "Ä¼" LATIN SMALL LETTER L WITH CEDILLA
        // U+013E: "Ä¾" LATIN SMALL LETTER L WITH CARON
        // U+0140: "Å€" LATIN SMALL LETTER L WITH MIDDLE DOT
        // U+0142: "Å‚" LATIN SMALL LETTER L WITH STROKE
        /* morekeys_l */ "\u013A,\u013C,\u013E,\u0140,\u0142",
        // U+011F: "ÄŸ" LATIN SMALL LETTER G WITH BREVE
        // U+0121: "Ä¡" LATIN SMALL LETTER G WITH DOT ABOVE
        // U+0123: "Ä£" LATIN SMALL LETTER G WITH CEDILLA
        /* morekeys_g */ "\u011F,\u0121,\u0123",
        /* single_angle_quotes */ null,
        /* double_angle_quotes */ null,
        // U+0159: "Å™" LATIN SMALL LETTER R WITH CARON
        // U+0155: "Å•" LATIN SMALL LETTER R WITH ACUTE
        // U+0157: "Å—" LATIN SMALL LETTER R WITH CEDILLA
        /* morekeys_r */ "\u0159,\u0155,\u0157",
        // U+0137: "Ä·" LATIN SMALL LETTER K WITH CEDILLA
        // U+0138: "Ä¸" LATIN SMALL LETTER KRA
        /* morekeys_k */ "\u0137,\u0138",
        /* morekeys_cyrillic_ie ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null,
        /* ~ morekeys_question */
        // U+0125: "Ä¥" LATIN SMALL LETTER H WITH CIRCUMFLEX
        // U+0127: "Ä§" LATIN SMALL LETTER H WITH STROKE
        /* morekeys_h */ "\u0125,\u0127",
        // U+0175: "Åµ" LATIN SMALL LETTER W WITH CIRCUMFLEX
        /* morekeys_w */ "w,\u0175",
        /* morekeys_east_slavic_row2_2 ~ */
        null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_tablet_punctuation */
        // U+0135: "Äµ" LATIN SMALL LETTER J WITH CIRCUMFLEX
        /* keyspec_spanish_row2_10 */ "\u0135",
        /* morekeys_bullet ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null,
        /* ~ label_wait_key */
        // U+0175: "Åµ" LATIN SMALL LETTER W WITH CIRCUMFLEX
        /* morekeys_v */ "w,\u0175",
        /* morekeys_j */ null,
        /* morekeys_q */ "q",
        /* morekeys_x */ "x",
        // U+015D: "Å�" LATIN SMALL LETTER S WITH CIRCUMFLEX
        /* keyspec_q */ "\u015D",
        // U+011D: "Ä�" LATIN SMALL LETTER G WITH CIRCUMFLEX
        /* keyspec_w */ "\u011D",
        // U+016D: "Å­" LATIN SMALL LETTER U WITH BREVE
        /* keyspec_y */ "\u016D",
        // U+0109: "Ä‰" LATIN SMALL LETTER C WITH CIRCUMFLEX
        /* keyspec_x */ "\u0109",
    };

    /* Locale es: Spanish */
    private static final String[] TEXTS_es = {
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+00AA: "Âª" FEMININE ORDINAL INDICATOR
        /* morekeys_a */ "\u00E1,\u00E0,\u00E4,\u00E2,\u00E3,\u00E5,\u0105,\u00E6,\u0101,\u00AA",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+00BA: "Âº" MASCULINE ORDINAL INDICATOR
        /* morekeys_o */ "\u00F3,\u00F2,\u00F6,\u00F4,\u00F5,\u00F8,\u0153,\u014D,\u00BA",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u00E8,\u00EB,\u00EA,\u0119,\u0117,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FC,\u00F9,\u00FB,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u00ED,\u00EF,\u00EC,\u00EE,\u012F,\u012B",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u00F1,\u0144",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        /* morekeys_c */ "\u00E7,\u0107,\u010D",
        /* double_quotes ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null,
        /* ~ morekeys_nordic_row2_11 */
        // U+00A1: "Â¡" INVERTED EXCLAMATION MARK
        // U+00BF: "Â¿" INVERTED QUESTION MARK
        /* morekeys_punctuation */ "!autoColumnOrder!9,\\,,?,!,#,),(,/,;,\u00A1,',@,:,-,\",+,\\%,&,\u00BF",
    };

    /* Locale et_EE: Estonian (Estonia) */
    private static final String[] TEXTS_et_EE = {
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        /* morekeys_a */ "\u00E4,\u0101,\u00E0,\u00E1,\u00E2,\u00E3,\u00E5,\u00E6,\u0105",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+0151: "Å‘" LATIN SMALL LETTER O WITH DOUBLE ACUTE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        /* morekeys_o */ "\u00F6,\u00F5,\u00F2,\u00F3,\u00F4,\u0153,\u0151,\u00F8",
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+011B: "Ä›" LATIN SMALL LETTER E WITH CARON
        /* morekeys_e */ "\u0113,\u00E8,\u0117,\u00E9,\u00EA,\u00EB,\u0119,\u011B",
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        // U+0173: "Å³" LATIN SMALL LETTER U WITH OGONEK
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+016F: "Å¯" LATIN SMALL LETTER U WITH RING ABOVE
        // U+0171: "Å±" LATIN SMALL LETTER U WITH DOUBLE ACUTE
        /* morekeys_u */ "\u00FC,\u016B,\u0173,\u00F9,\u00FA,\u00FB,\u016F,\u0171",
        /* keylabel_to_alpha */ null,
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+0131: "Ä±" LATIN SMALL LETTER DOTLESS I
        /* morekeys_i */ "\u012B,\u00EC,\u012F,\u00ED,\u00EE,\u00EF,\u0131",
        // U+0146: "Å†" LATIN SMALL LETTER N WITH CEDILLA
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u0146,\u00F1,\u0144",
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        /* morekeys_c */ "\u010D,\u00E7,\u0107",
        /* double_quotes */ "!text/double_9qm_lqm",
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+015F: "ÅŸ" LATIN SMALL LETTER S WITH CEDILLA
        /* morekeys_s */ "\u0161,\u00DF,\u015B,\u015F",
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        // U+00FF: "Ã¿" LATIN SMALL LETTER Y WITH DIAERESIS
        /* morekeys_y */ "\u00FD,\u00FF",
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        // U+017C: "Å¼" LATIN SMALL LETTER Z WITH DOT ABOVE
        // U+017A: "Åº" LATIN SMALL LETTER Z WITH ACUTE
        /* morekeys_z */ "\u017E,\u017C,\u017A",
        // U+010F: "Ä�" LATIN SMALL LETTER D WITH CARON
        /* morekeys_d */ "\u010F",
        // U+0163: "Å£" LATIN SMALL LETTER T WITH CEDILLA
        // U+0165: "Å¥" LATIN SMALL LETTER T WITH CARON
        /* morekeys_t */ "\u0163,\u0165",
        // U+013C: "Ä¼" LATIN SMALL LETTER L WITH CEDILLA
        // U+0142: "Å‚" LATIN SMALL LETTER L WITH STROKE
        // U+013A: "Äº" LATIN SMALL LETTER L WITH ACUTE
        // U+013E: "Ä¾" LATIN SMALL LETTER L WITH CARON
        /* morekeys_l */ "\u013C,\u0142,\u013A,\u013E",
        // U+0123: "Ä£" LATIN SMALL LETTER G WITH CEDILLA
        // U+011F: "ÄŸ" LATIN SMALL LETTER G WITH BREVE
        /* morekeys_g */ "\u0123,\u011F",
        /* single_angle_quotes */ null,
        /* double_angle_quotes */ null,
        // U+0157: "Å—" LATIN SMALL LETTER R WITH CEDILLA
        // U+0159: "Å™" LATIN SMALL LETTER R WITH CARON
        // U+0155: "Å•" LATIN SMALL LETTER R WITH ACUTE
        /* morekeys_r */ "\u0157,\u0159,\u0155",
        // U+0137: "Ä·" LATIN SMALL LETTER K WITH CEDILLA
        /* morekeys_k */ "\u0137",
        /* morekeys_cyrillic_ie */ null,
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        /* keyspec_nordic_row1_11 */ "\u00FC",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        /* keyspec_nordic_row2_10 */ "\u00F6",
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        /* keyspec_nordic_row2_11 */ "\u00E4",
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        /* morekeys_nordic_row2_10 */ "\u00F5",
    };

    /* Locale eu_ES: Basque (Spain) */
    private static final String[] TEXTS_eu_ES = {
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+00AA: "Âª" FEMININE ORDINAL INDICATOR
        /* morekeys_a */ "\u00E1,\u00E0,\u00E4,\u00E2,\u00E3,\u00E5,\u0105,\u00E6,\u0101,\u00AA",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+00BA: "Âº" MASCULINE ORDINAL INDICATOR
        /* morekeys_o */ "\u00F3,\u00F2,\u00F6,\u00F4,\u00F5,\u00F8,\u0153,\u014D,\u00BA",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u00E8,\u00EB,\u00EA,\u0119,\u0117,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FC,\u00F9,\u00FB,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u00ED,\u00EF,\u00EC,\u00EE,\u012F,\u012B",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u00F1,\u0144",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        /* morekeys_c */ "\u00E7,\u0107,\u010D",
    };

    /* Locale fa: Persian */
    private static final String[] TEXTS_fa = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0627: "Ø§" ARABIC LETTER ALEF
        // U+200C: ZERO WIDTH NON-JOINER
        // U+0628: "Ø¨" ARABIC LETTER BEH
        // U+067E: "Ù¾" ARABIC LETTER PEH
        /* keylabel_to_alpha */ "\u0627\u200C\u0628\u200C\u067E",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+FDFC: "ï·¼" RIAL SIGN
        /* keyspec_currency */ "\uFDFC",
        /* morekeys_y ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null,
        /* ~ morekeys_cyrillic_soft_sign */
        // U+06F1: "Û±" EXTENDED ARABIC-INDIC DIGIT ONE
        /* keyspec_symbols_1 */ "\u06F1",
        // U+06F2: "Û²" EXTENDED ARABIC-INDIC DIGIT TWO
        /* keyspec_symbols_2 */ "\u06F2",
        // U+06F3: "Û³" EXTENDED ARABIC-INDIC DIGIT THREE
        /* keyspec_symbols_3 */ "\u06F3",
        // U+06F4: "Û´" EXTENDED ARABIC-INDIC DIGIT FOUR
        /* keyspec_symbols_4 */ "\u06F4",
        // U+06F5: "Ûµ" EXTENDED ARABIC-INDIC DIGIT FIVE
        /* keyspec_symbols_5 */ "\u06F5",
        // U+06F6: "Û¶" EXTENDED ARABIC-INDIC DIGIT SIX
        /* keyspec_symbols_6 */ "\u06F6",
        // U+06F7: "Û·" EXTENDED ARABIC-INDIC DIGIT SEVEN
        /* keyspec_symbols_7 */ "\u06F7",
        // U+06F8: "Û¸" EXTENDED ARABIC-INDIC DIGIT EIGHT
        /* keyspec_symbols_8 */ "\u06F8",
        // U+06F9: "Û¹" EXTENDED ARABIC-INDIC DIGIT NINE
        /* keyspec_symbols_9 */ "\u06F9",
        // U+06F0: "Û°" EXTENDED ARABIC-INDIC DIGIT ZERO
        /* keyspec_symbols_0 */ "\u06F0",
        // Label for "switch to symbols" key.
        // U+061F: "ØŸ" ARABIC QUESTION MARK
        /* keylabel_to_symbol */ "\u06F3\u06F2\u06F1\u061F",
        /* additional_morekeys_symbols_1 */ "1",
        /* additional_morekeys_symbols_2 */ "2",
        /* additional_morekeys_symbols_3 */ "3",
        /* additional_morekeys_symbols_4 */ "4",
        /* additional_morekeys_symbols_5 */ "5",
        /* additional_morekeys_symbols_6 */ "6",
        /* additional_morekeys_symbols_7 */ "7",
        /* additional_morekeys_symbols_8 */ "8",
        /* additional_morekeys_symbols_9 */ "9",
        // U+066B: "Ù«" ARABIC DECIMAL SEPARATOR
        // U+066C: "Ù¬" ARABIC THOUSANDS SEPARATOR
        /* additional_morekeys_symbols_0 */ "0,\u066B,\u066C",
        /* morekeys_tablet_period */ "!text/morekeys_arabic_diacritics",
        /* morekeys_nordic_row2_11 */ null,
        /* morekeys_punctuation */ null,
        // U+060C: "ØŒ" ARABIC COMMA
        // U+061B: "Ø›" ARABIC SEMICOLON
        // U+061F: "ØŸ" ARABIC QUESTION MARK
        // U+00AB: "Â«" LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+00BB: "Â»" RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
        /* keyspec_tablet_comma */ "\u060C",
        /* keyspec_period */ null,
        /* morekeys_period */ "!text/morekeys_arabic_diacritics",
        /* keyspec_tablet_period ~ */
        null, null, null, null, null, null, null,
        /* ~ morekeys_swiss_row2_11 */
        // U+2605: "â˜…" BLACK STAR
        // U+066D: "Ù­" ARABIC FIVE POINTED STAR
        /* morekeys_star */ "\u2605,\u066D",
        /* keyspec_left_parenthesis */ "(|)",
        /* keyspec_right_parenthesis */ ")|(",
        /* keyspec_left_square_bracket */ "[|]",
        /* keyspec_right_square_bracket */ "]|[",
        /* keyspec_left_curly_bracket */ "{|}",
        /* keyspec_right_curly_bracket */ "}|{",
        /* keyspec_less_than */ "<|>",
        /* keyspec_greater_than */ ">|<",
        /* keyspec_less_than_equal */ "\u2264|\u2265",
        /* keyspec_greater_than_equal */ "\u2265|\u2264",
        /* keyspec_left_double_angle_quote */ "\u00AB|\u00BB",
        /* keyspec_right_double_angle_quote */ "\u00BB|\u00AB",
        /* keyspec_left_single_angle_quote */ "\u2039|\u203A",
        /* keyspec_right_single_angle_quote */ "\u203A|\u2039",
        // U+060C: "ØŒ" ARABIC COMMA
        /* keyspec_comma */ "\u060C",
        /* morekeys_tablet_comma */ "!fixedColumnOrder!4,:,!,\u061F,\u061B,-,!text/keyspec_left_double_angle_quote,!text/keyspec_right_double_angle_quote",
        // U+064B: "Ù‹" ARABIC FATHATAN
        /* keyhintlabel_period */ "\u064B",
        // U+00BF: "Â¿" INVERTED QUESTION MARK
        /* morekeys_question */ "?,\u00BF",
        /* morekeys_h ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ keyspec_spanish_row2_10 */
        // U+266A: "â™ª" EIGHTH NOTE
        /* morekeys_bullet */ "\u266A",
        // The all letters need to be mirrored are found at
        // http://www.unicode.org/Public/6.1.0/ucd/BidiMirroring.txt
        // U+FD3E: "ï´¾" ORNATE LEFT PARENTHESIS
        // U+FD3F: "ï´¿" ORNATE RIGHT PARENTHESIS
        /* morekeys_left_parenthesis */ "!fixedColumnOrder!4,\uFD3E|\uFD3F,!text/keyspecs_left_parenthesis_more_keys",
        /* morekeys_right_parenthesis */ "!fixedColumnOrder!4,\uFD3F|\uFD3E,!text/keyspecs_right_parenthesis_more_keys",
        // U+0655: "Ù•" ARABIC HAMZA BELOW
        // U+0652: "Ù’" ARABIC SUKUN
        // U+0651: "Ù‘" ARABIC SHADDA
        // U+064C: "ÙŒ" ARABIC DAMMATAN
        // U+064D: "Ù�" ARABIC KASRATAN
        // U+064B: "Ù‹" ARABIC FATHATAN
        // U+0654: "Ù”" ARABIC HAMZA ABOVE
        // U+0656: "Ù–" ARABIC SUBSCRIPT ALEF
        // U+0670: "Ù°" ARABIC LETTER SUPERSCRIPT ALEF
        // U+0653: "Ù“" ARABIC MADDAH ABOVE
        // U+064F: "Ù�" ARABIC DAMMA
        // U+0650: "Ù�" ARABIC KASRA
        // U+064E: "ÙŽ" ARABIC FATHA
        // U+0640: "Ù€" ARABIC TATWEEL
        // In order to make Tatweel easily distinguishable from other punctuations, we use consecutive Tatweels only for its displayed label.
        // Note: The space character is needed as a preceding letter to draw Arabic diacritics characters correctly.
        /* morekeys_arabic_diacritics */ "!fixedColumnOrder!7, \u0655|\u0655, \u0652|\u0652, \u0651|\u0651, \u064C|\u064C, \u064D|\u064D, \u064B|\u064B, \u0654|\u0654, \u0656|\u0656, \u0670|\u0670, \u0653|\u0653, \u064F|\u064F, \u0650|\u0650, \u064E|\u064E,\u0640\u0640\u0640|\u0640",
        /* keyhintlabel_tablet_comma */ "\u061F",
        /* keyhintlabel_tablet_period */ "\u064B",
        /* keyspec_symbols_question */ "\u061F",
        /* keyspec_symbols_semicolon */ "\u061B",
        // U+066A: "Ùª" ARABIC PERCENT SIGN
        /* keyspec_symbols_percent */ "\u066A",
        /* morekeys_symbols_semicolon */ ";",
        // U+2030: "â€°" PER MILLE SIGN
        /* morekeys_symbols_percent */ "\\%,\u2030",
        /* label_go_key ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null,
        /* ~ morekeys_plus */
        // U+2264: "â‰¤" LESS-THAN OR EQUAL TO
        // U+2265: "â‰¥" GREATER-THAN EQUAL TO
        // U+00AB: "Â«" LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+00BB: "Â»" RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+2039: "â€¹" SINGLE LEFT-POINTING ANGLE QUOTATION MARK
        // U+203A: "â€º" SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
        /* morekeys_less_than */ "!fixedColumnOrder!3,!text/keyspec_left_single_angle_quote,!text/keyspec_less_than_equal,!text/keyspec_less_than",
        /* morekeys_greater_than */ "!fixedColumnOrder!3,!text/keyspec_right_single_angle_quote,!text/keyspec_greater_than_equal,!text/keyspec_greater_than",
    };

    /* Locale fi: Finnish */
    private static final String[] TEXTS_fi = {
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u00E4,\u00E5,\u00E6,\u00E0,\u00E1,\u00E2,\u00E3,\u0101",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F6,\u00F8,\u00F4,\u00F2,\u00F3,\u00F5,\u0153,\u014D",
        /* morekeys_e */ null,
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        /* morekeys_u */ "\u00FC",
        /* keylabel_to_alpha ~ */
        null, null, null, null, null,
        /* ~ double_quotes */
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        /* morekeys_s */ "\u0161,\u00DF,\u015B",
        /* single_quotes ~ */
        null, null, null,
        /* ~ morekeys_y */
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        // U+017A: "Åº" LATIN SMALL LETTER Z WITH ACUTE
        // U+017C: "Å¼" LATIN SMALL LETTER Z WITH DOT ABOVE
        /* morekeys_z */ "\u017E,\u017A,\u017C",
        /* morekeys_d ~ */
        null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_cyrillic_ie */
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        /* keyspec_nordic_row1_11 */ "\u00E5",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        /* keyspec_nordic_row2_10 */ "\u00F6",
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        /* keyspec_nordic_row2_11 */ "\u00E4",
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        /* morekeys_nordic_row2_10 */ "\u00F8",
        /* keyspec_east_slavic_row1_9 ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_tablet_period */
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        /* morekeys_nordic_row2_11 */ "\u00E6",
    };

    /* Locale fr: French */
    private static final String[] TEXTS_fr = {
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+00AA: "Âª" FEMININE ORDINAL INDICATOR
        /* morekeys_a */ "\u00E0,\u00E2,%,\u00E6,\u00E1,\u00E4,\u00E3,\u00E5,\u0101,\u00AA",
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+00BA: "Âº" MASCULINE ORDINAL INDICATOR
        /* morekeys_o */ "\u00F4,\u0153,%,\u00F6,\u00F2,\u00F3,\u00F5,\u00F8,\u014D,\u00BA",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u00E8,\u00EA,\u00EB,%,\u0119,\u0117,\u0113",
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00F9,\u00FB,%,\u00FC,\u00FA,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u00EE,%,\u00EF,\u00EC,\u00ED,\u012F,\u012B",
        /* morekeys_n */ null,
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        /* morekeys_c */ "\u00E7,%,\u0107,\u010D",
        /* double_quotes ~ */
        null, null, null, null,
        /* ~ keyspec_currency */
        // U+00FF: "Ã¿" LATIN SMALL LETTER Y WITH DIAERESIS
        /* morekeys_y */ "%,\u00FF",
        /* morekeys_z ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null,
        /* ~ keyspec_tablet_period */
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        /* keyspec_swiss_row1_11 */ "\u00E8",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        /* keyspec_swiss_row2_10 */ "\u00E9",
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        /* keyspec_swiss_row2_11 */ "\u00E0",
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        /* morekeys_swiss_row1_11 */ "\u00FC",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        /* morekeys_swiss_row2_10 */ "\u00F6",
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        /* morekeys_swiss_row2_11 */ "\u00E4",
    };

    /* Locale gl_ES: Gallegan (Spain) */
    private static final String[] TEXTS_gl_ES = {
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+00AA: "Âª" FEMININE ORDINAL INDICATOR
        /* morekeys_a */ "\u00E1,\u00E0,\u00E4,\u00E2,\u00E3,\u00E5,\u0105,\u00E6,\u0101,\u00AA",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+00BA: "Âº" MASCULINE ORDINAL INDICATOR
        /* morekeys_o */ "\u00F3,\u00F2,\u00F6,\u00F4,\u00F5,\u00F8,\u0153,\u014D,\u00BA",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u00E8,\u00EB,\u00EA,\u0119,\u0117,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FC,\u00F9,\u00FB,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u00ED,\u00EF,\u00EC,\u00EE,\u012F,\u012B",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u00F1,\u0144",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        /* morekeys_c */ "\u00E7,\u0107,\u010D",
    };

    /* Locale hi: Hindi */
    private static final String[] TEXTS_hi = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0915: "à¤•" DEVANAGARI LETTER KA
        // U+0916: "à¤–" DEVANAGARI LETTER KHA
        // U+0917: "à¤—" DEVANAGARI LETTER GA
        /* keylabel_to_alpha */ "\u0915\u0916\u0917",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+20B9: "â‚¹" INDIAN RUPEE SIGN
        /* keyspec_currency */ "\u20B9",
        /* morekeys_y ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null,
        /* ~ morekeys_cyrillic_soft_sign */
        // U+0967: "à¥§" DEVANAGARI DIGIT ONE
        /* keyspec_symbols_1 */ "\u0967",
        // U+0968: "à¥¨" DEVANAGARI DIGIT TWO
        /* keyspec_symbols_2 */ "\u0968",
        // U+0969: "à¥©" DEVANAGARI DIGIT THREE
        /* keyspec_symbols_3 */ "\u0969",
        // U+096A: "à¥ª" DEVANAGARI DIGIT FOUR
        /* keyspec_symbols_4 */ "\u096A",
        // U+096B: "à¥«" DEVANAGARI DIGIT FIVE
        /* keyspec_symbols_5 */ "\u096B",
        // U+096C: "à¥¬" DEVANAGARI DIGIT SIX
        /* keyspec_symbols_6 */ "\u096C",
        // U+096D: "à¥­" DEVANAGARI DIGIT SEVEN
        /* keyspec_symbols_7 */ "\u096D",
        // U+096E: "à¥®" DEVANAGARI DIGIT EIGHT
        /* keyspec_symbols_8 */ "\u096E",
        // U+096F: "à¥¯" DEVANAGARI DIGIT NINE
        /* keyspec_symbols_9 */ "\u096F",
        // U+0966: "à¥¦" DEVANAGARI DIGIT ZERO
        /* keyspec_symbols_0 */ "\u0966",
        // Label for "switch to symbols" key.
        /* keylabel_to_symbol */ "?\u0967\u0968\u0969",
        /* additional_morekeys_symbols_1 */ "1",
        /* additional_morekeys_symbols_2 */ "2",
        /* additional_morekeys_symbols_3 */ "3",
        /* additional_morekeys_symbols_4 */ "4",
        /* additional_morekeys_symbols_5 */ "5",
        /* additional_morekeys_symbols_6 */ "6",
        /* additional_morekeys_symbols_7 */ "7",
        /* additional_morekeys_symbols_8 */ "8",
        /* additional_morekeys_symbols_9 */ "9",
        /* additional_morekeys_symbols_0 */ "0",
        /* morekeys_tablet_period */ "!autoColumnOrder!8,\\,,.,',#,),(,/,;,@,:,-,\",+,\\%,&",
        /* morekeys_nordic_row2_11 ~ */
        null, null, null,
        /* ~ keyspec_tablet_comma */
        // U+0964: "à¥¤" DEVANAGARI DANDA
        /* keyspec_period */ "\u0964",
        /* morekeys_period */ "!autoColumnOrder!9,\\,,.,?,!,#,),(,/,;,',@,:,-,\",+,\\%,&",
        /* keyspec_tablet_period */ "\u0964",
    };

    /* Locale hi_ZZ: Hindi (ZZ) */
    private static final String[] TEXTS_hi_ZZ = {
        /* morekeys_a ~ */
        null, null, null, null, null, null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+20B9: "â‚¹" INDIAN RUPEE SIGN
        /* keyspec_currency */ "\u20B9",
        /* morekeys_y ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null,
        /* ~ morekeys_symbols_percent */
        /* label_go_key */ "Go",
        /* label_send_key */ "Send",
        /* label_next_key */ "Next",
        /* label_done_key */ "Done",
        /* label_search_key */ "Search",
        /* label_previous_key */ "Prev",
        /* label_pause_key */ "Pause",
        /* label_wait_key */ "Wait",
    };

    /* Locale hr: Croatian */
    private static final String[] TEXTS_hr = {
        /* morekeys_a ~ */
        null, null, null, null, null, null,
        /* ~ morekeys_i */
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u00F1,\u0144",
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        /* morekeys_c */ "\u010D,\u0107,\u00E7",
        /* double_quotes */ "!text/double_9qm_rqm",
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        /* morekeys_s */ "\u0161,\u015B,\u00DF",
        /* single_quotes */ "!text/single_9qm_rqm",
        /* keyspec_currency */ null,
        /* morekeys_y */ null,
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        // U+017A: "Åº" LATIN SMALL LETTER Z WITH ACUTE
        // U+017C: "Å¼" LATIN SMALL LETTER Z WITH DOT ABOVE
        /* morekeys_z */ "\u017E,\u017A,\u017C",
        // U+0111: "Ä‘" LATIN SMALL LETTER D WITH STROKE
        /* morekeys_d */ "\u0111",
        /* morekeys_t ~ */
        null, null, null,
        /* ~ morekeys_g */
        /* single_angle_quotes */ "!text/single_raqm_laqm",
        /* double_angle_quotes */ "!text/double_raqm_laqm",
    };

    /* Locale hu: Hungarian */
    private static final String[] TEXTS_hu = {
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u00E1,\u00E0,\u00E2,\u00E4,\u00E6,\u00E3,\u00E5,\u0101",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+0151: "Å‘" LATIN SMALL LETTER O WITH DOUBLE ACUTE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F3,\u00F6,\u0151,\u00F4,\u00F2,\u00F5,\u0153,\u00F8,\u014D",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u00E8,\u00EA,\u00EB,\u0119,\u0117,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+0171: "Å±" LATIN SMALL LETTER U WITH DOUBLE ACUTE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FC,\u0171,\u00FB,\u00F9,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u00ED,\u00EE,\u00EF,\u00EC,\u012F,\u012B",
        /* morekeys_n */ null,
        /* morekeys_c */ null,
        /* double_quotes */ "!text/double_9qm_rqm",
        /* morekeys_s */ null,
        /* single_quotes */ "!text/single_9qm_rqm",
        /* keyspec_currency ~ */
        null, null, null, null, null, null, null,
        /* ~ morekeys_g */
        /* single_angle_quotes */ "!text/single_raqm_laqm",
        /* double_angle_quotes */ "!text/double_raqm_laqm",
    };

    /* Locale hy_AM: Armenian (Armenia) */
    private static final String[] TEXTS_hy_AM = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0531: "Ô±" ARMENIAN CAPITAL LETTER AYB
        // U+0532: "Ô²" ARMENIAN CAPITAL LETTER BEN
        // U+0533: "Ô³" ARMENIAN CAPITAL LETTER GIM
        /* keylabel_to_alpha */ "\u0531\u0532\u0533",
        /* morekeys_i ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null,
        /* ~ additional_morekeys_symbols_0 */
        /* morekeys_tablet_period */ "!text/morekeys_punctuation",
        /* morekeys_nordic_row2_11 */ null,
        // U+055E: "Õž" ARMENIAN QUESTION MARK
        // U+055C: "Õœ" ARMENIAN EXCLAMATION MARK
        // U+055A: "Õš" ARMENIAN APOSTROPHE
        // U+0559: "Õ™" ARMENIAN MODIFIER LETTER LEFT HALF RING
        // U+055D: "Õ�" ARMENIAN COMMA
        // U+055B: "Õ›" ARMENIAN EMPHASIS MARK
        // U+058A: "ÖŠ" ARMENIAN HYPHEN
        // U+00BB: "Â»" RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+00AB: "Â«" LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+055F: "ÕŸ" ARMENIAN ABBREVIATION MARK
        /* morekeys_punctuation */ "!autoColumnOrder!8,\\,,\u055E,\u055C,.,\u055A,\u0559,?,!,\u055D,\u055B,\u058A,\u00BB,\u00AB,\u055F,;,:",
        /* keyspec_tablet_comma */ "\u055D",
        // U+0589: "Ö‰" ARMENIAN FULL STOP
        /* keyspec_period */ "\u0589",
        /* morekeys_period */ null,
        /* keyspec_tablet_period */ "\u0589",
        /* keyspec_swiss_row1_11 ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null,
        /* ~ keyspec_right_single_angle_quote */
        // U+058F: "Ö�" ARMENIAN DRAM SIGN
        // TODO: Enable this when we have glyph for the following letter
        // <string name="keyspec_currency">&#x058F;</string>
        // 
        // U+055D: "Õ�" ARMENIAN COMMA
        /* keyspec_comma */ "\u055D",
        /* morekeys_tablet_comma */ null,
        /* keyhintlabel_period */ null,
        // U+055E: "Õž" ARMENIAN QUESTION MARK
        // U+00BF: "Â¿" INVERTED QUESTION MARK
        /* morekeys_question */ "\u055E,\u00BF",
        /* morekeys_h ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null,
        /* ~ morekeys_greater_than */
        // U+055C: "Õœ" ARMENIAN EXCLAMATION MARK
        // U+00A1: "Â¡" INVERTED EXCLAMATION MARK
        /* morekeys_exclamation */ "\u055C,\u00A1",
    };

    /* Locale is: Icelandic */
    private static final String[] TEXTS_is = {
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u00E1,\u00E4,\u00E6,\u00E5,\u00E0,\u00E2,\u00E3,\u0101",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F3,\u00F6,\u00F4,\u00F2,\u00F5,\u0153,\u00F8,\u014D",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u00EB,\u00E8,\u00EA,\u0119,\u0117,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FC,\u00FB,\u00F9,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u00ED,\u00EF,\u00EE,\u00EC,\u012F,\u012B",
        /* morekeys_n */ null,
        /* morekeys_c */ null,
        /* double_quotes */ "!text/double_9qm_lqm",
        /* morekeys_s */ null,
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        // U+00FF: "Ã¿" LATIN SMALL LETTER Y WITH DIAERESIS
        /* morekeys_y */ "\u00FD,\u00FF",
        /* morekeys_z */ null,
        // U+00F0: "Ã°" LATIN SMALL LETTER ETH
        /* morekeys_d */ "\u00F0",
        // U+00FE: "Ã¾" LATIN SMALL LETTER THORN
        /* morekeys_t */ "\u00FE",
    };

    /* Locale it: Italian */
    private static final String[] TEXTS_it = {
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+00AA: "Âª" FEMININE ORDINAL INDICATOR
        /* morekeys_a */ "\u00E0,\u00E1,\u00E2,\u00E4,\u00E6,\u00E3,\u00E5,\u0101,\u00AA",
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+00BA: "Âº" MASCULINE ORDINAL INDICATOR
        /* morekeys_o */ "\u00F2,\u00F3,\u00F4,\u00F6,\u00F5,\u0153,\u00F8,\u014D,\u00BA",
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E8,\u00E9,\u00EA,\u00EB,\u0119,\u0117,\u0113",
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00F9,\u00FA,\u00FB,\u00FC,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u00EC,\u00ED,\u00EE,\u00EF,\u012F,\u012B",
        /* morekeys_n ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null,
        /* ~ keyspec_tablet_period */
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        /* keyspec_swiss_row1_11 */ "\u00FC",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        /* keyspec_swiss_row2_10 */ "\u00F6",
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        /* keyspec_swiss_row2_11 */ "\u00E4",
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        /* morekeys_swiss_row1_11 */ "\u00E8",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        /* morekeys_swiss_row2_10 */ "\u00E9",
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        /* morekeys_swiss_row2_11 */ "\u00E0",
    };

    /* Locale iw: Hebrew */
    private static final String[] TEXTS_iw = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+05D0: "×�" HEBREW LETTER ALEF
        // U+05D1: "×‘" HEBREW LETTER BET
        // U+05D2: "×’" HEBREW LETTER GIMEL
        /* keylabel_to_alpha */ "\u05D0\u05D1\u05D2",
        /* morekeys_i ~ */
        null, null, null,
        /* ~ morekeys_c */
        /* double_quotes */ "!text/double_rqm_9qm",
        /* morekeys_s */ null,
        /* single_quotes */ "!text/single_rqm_9qm",
        // U+20AA: "â‚ª" NEW SHEQEL SIGN
        /* keyspec_currency */ "\u20AA",
        /* morekeys_y ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_swiss_row2_11 */
        // U+2605: "â˜…" BLACK STAR
        /* morekeys_star */ "\u2605",
        // The all letters need to be mirrored are found at
        // http://www.unicode.org/Public/6.1.0/ucd/BidiMirroring.txt
        // U+2264: "â‰¤" LESS-THAN OR EQUAL TO
        // U+2265: "â‰¥" GREATER-THAN EQUAL TO
        // U+00AB: "Â«" LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+00BB: "Â»" RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
        // U+2039: "â€¹" SINGLE LEFT-POINTING ANGLE QUOTATION MARK
        // U+203A: "â€º" SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
        /* keyspec_left_parenthesis */ "(|)",
        /* keyspec_right_parenthesis */ ")|(",
        /* keyspec_left_square_bracket */ "[|]",
        /* keyspec_right_square_bracket */ "]|[",
        /* keyspec_left_curly_bracket */ "{|}",
        /* keyspec_right_curly_bracket */ "}|{",
        /* keyspec_less_than */ "<|>",
        /* keyspec_greater_than */ ">|<",
        /* keyspec_less_than_equal */ "\u2264|\u2265",
        /* keyspec_greater_than_equal */ "\u2265|\u2264",
        /* keyspec_left_double_angle_quote */ "\u00AB|\u00BB",
        /* keyspec_right_double_angle_quote */ "\u00BB|\u00AB",
        /* keyspec_left_single_angle_quote */ "\u2039|\u203A",
        /* keyspec_right_single_angle_quote */ "\u203A|\u2039",
        /* keyspec_comma ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null,
        /* ~ morekeys_currency_dollar */
        // U+00B1: "Â±" PLUS-MINUS SIGN
        // U+FB29: "ï¬©" HEBREW LETTER ALTERNATIVE PLUS SIGN
        /* morekeys_plus */ "\u00B1,\uFB29",
    };

    /* Locale ka_GE: Georgian (Georgia) */
    private static final String[] TEXTS_ka_GE = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+10D0: "áƒ�" GEORGIAN LETTER AN
        // U+10D1: "áƒ‘" GEORGIAN LETTER BAN
        // U+10D2: "áƒ’" GEORGIAN LETTER GAN
        /* keylabel_to_alpha */ "\u10D0\u10D1\u10D2",
        /* morekeys_i ~ */
        null, null, null,
        /* ~ morekeys_c */
        /* double_quotes */ "!text/double_9qm_lqm",
        /* morekeys_s */ null,
        /* single_quotes */ "!text/single_9qm_lqm",
    };

    /* Locale kk: Kazakh */
    private static final String[] TEXTS_kk = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0410: "Ð�" CYRILLIC CAPITAL LETTER A
        // U+0411: "Ð‘" CYRILLIC CAPITAL LETTER BE
        // U+0412: "Ð’" CYRILLIC CAPITAL LETTER VE
        /* keylabel_to_alpha */ "\u0410\u0411\u0412",
        /* morekeys_i ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null,
        /* ~ morekeys_k */
        // U+0451: "Ñ‘" CYRILLIC SMALL LETTER IO
        /* morekeys_cyrillic_ie */ "\u0451",
        /* keyspec_nordic_row1_11 ~ */
        null, null, null, null,
        /* ~ morekeys_nordic_row2_10 */
        // U+0449: "Ñ‰" CYRILLIC SMALL LETTER SHCHA
        /* keyspec_east_slavic_row1_9 */ "\u0449",
        // U+044B: "Ñ‹" CYRILLIC SMALL LETTER YERU
        /* keyspec_east_slavic_row2_2 */ "\u044B",
        // U+044D: "Ñ�" CYRILLIC SMALL LETTER E
        /* keyspec_east_slavic_row2_11 */ "\u044D",
        // U+0438: "Ð¸" CYRILLIC SMALL LETTER I
        /* keyspec_east_slavic_row3_5 */ "\u0438",
        // U+044A: "ÑŠ" CYRILLIC SMALL LETTER HARD SIGN
        /* morekeys_cyrillic_soft_sign */ "\u044A",
        /* keyspec_symbols_1 ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_w */
        // U+0456: "Ñ–" CYRILLIC SMALL LETTER BYELORUSSIAN-UKRAINIAN I
        /* morekeys_east_slavic_row2_2 */ "\u0456",
        // U+04AF: "Ò¯" CYRILLIC SMALL LETTER STRAIGHT U
        // U+04B1: "Ò±" CYRILLIC SMALL LETTER STRAIGHT U WITH STROKE
        /* morekeys_cyrillic_u */ "\u04AF,\u04B1",
        // U+04A3: "Ò£" CYRILLIC SMALL LETTER EN WITH DESCENDER
        /* morekeys_cyrillic_en */ "\u04A3",
        // U+0493: "Ò“" CYRILLIC SMALL LETTER GHE WITH STROKE
        /* morekeys_cyrillic_ghe */ "\u0493",
        // U+04E9: "Ó©" CYRILLIC SMALL LETTER BARRED O
        /* morekeys_cyrillic_o */ "\u04E9",
        /* morekeys_cyrillic_i ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null,
        /* ~ keyspec_x */
        // U+04BB: "Ò»" CYRILLIC SMALL LETTER SHHA
        /* morekeys_east_slavic_row2_11 */ "\u04BB",
        // U+049B: "Ò›" CYRILLIC SMALL LETTER KA WITH DESCENDER
        /* morekeys_cyrillic_ka */ "\u049B",
        // U+04D9: "Ó™" CYRILLIC SMALL LETTER SCHWA
        /* morekeys_cyrillic_a */ "\u04D9",
    };

    /* Locale km_KH: Khmer (Cambodia) */
    private static final String[] TEXTS_km_KH = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+1780: "áž€" KHMER LETTER KA
        // U+1781: "áž�" KHMER LETTER KHA
        // U+1782: "áž‚" KHMER LETTER KO
        /* keylabel_to_alpha */ "\u1780\u1781\u1782",
        /* morekeys_i ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null,
        /* ~ morekeys_cyrillic_a */
        // U+17DB: "áŸ›" KHMER CURRENCY SYMBOL RIEL
        /* morekeys_currency_dollar */ "\u17DB,\u00A2,\u00A3,\u20AC,\u00A5,\u20B1",
    };

    /* Locale kn_IN: Kannada (India) */
    private static final String[] TEXTS_kn_IN = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0C85: "à²…" KANNADA LETTER A
        // U+0C86: "à²†" KANNADA LETTER AA
        // U+0C87: "à²‡" KANNADA LETTER I
        /* keylabel_to_alpha */ "\u0C85\u0C86\u0C87",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+20B9: "â‚¹" INDIAN RUPEE SIGN
        /* keyspec_currency */ "\u20B9",
    };

    /* Locale ky: Kirghiz */
    private static final String[] TEXTS_ky = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0410: "Ð�" CYRILLIC CAPITAL LETTER A
        // U+0411: "Ð‘" CYRILLIC CAPITAL LETTER BE
        // U+0412: "Ð’" CYRILLIC CAPITAL LETTER VE
        /* keylabel_to_alpha */ "\u0410\u0411\u0412",
        /* morekeys_i ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null,
        /* ~ morekeys_k */
        // U+0451: "Ñ‘" CYRILLIC SMALL LETTER IO
        /* morekeys_cyrillic_ie */ "\u0451",
        /* keyspec_nordic_row1_11 ~ */
        null, null, null, null,
        /* ~ morekeys_nordic_row2_10 */
        // U+0449: "Ñ‰" CYRILLIC SMALL LETTER SHCHA
        /* keyspec_east_slavic_row1_9 */ "\u0449",
        // U+044B: "Ñ‹" CYRILLIC SMALL LETTER YERU
        /* keyspec_east_slavic_row2_2 */ "\u044B",
        // U+044D: "Ñ�" CYRILLIC SMALL LETTER E
        /* keyspec_east_slavic_row2_11 */ "\u044D",
        // U+0438: "Ð¸" CYRILLIC SMALL LETTER I
        /* keyspec_east_slavic_row3_5 */ "\u0438",
        // U+044A: "ÑŠ" CYRILLIC SMALL LETTER HARD SIGN
        /* morekeys_cyrillic_soft_sign */ "\u044A",
        /* keyspec_symbols_1 ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_east_slavic_row2_2 */
        // U+04AF: "Ò¯" CYRILLIC SMALL LETTER STRAIGHT U
        /* morekeys_cyrillic_u */ "\u04AF",
        // U+04A3: "Ò£" CYRILLIC SMALL LETTER EN WITH DESCENDER
        /* morekeys_cyrillic_en */ "\u04A3",
        /* morekeys_cyrillic_ghe */ null,
        // U+04E9: "Ó©" CYRILLIC SMALL LETTER BARRED O
        /* morekeys_cyrillic_o */ "\u04E9",
    };

    /* Locale lo_LA: Lao (Laos) */
    private static final String[] TEXTS_lo_LA = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0E81: "àº�" LAO LETTER KO
        // U+0E82: "àº‚" LAO LETTER KHO SUNG
        // U+0E84: "àº„" LAO LETTER KHO TAM
        /* keylabel_to_alpha */ "\u0E81\u0E82\u0E84",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+20AD: "â‚­" KIP SIGN
        /* keyspec_currency */ "\u20AD",
    };

    /* Locale lt: Lithuanian */
    private static final String[] TEXTS_lt = {
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        /* morekeys_a */ "\u0105,\u00E4,\u0101,\u00E0,\u00E1,\u00E2,\u00E3,\u00E5,\u00E6",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+0151: "Å‘" LATIN SMALL LETTER O WITH DOUBLE ACUTE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        /* morekeys_o */ "\u00F6,\u00F5,\u00F2,\u00F3,\u00F4,\u0153,\u0151,\u00F8",
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+011B: "Ä›" LATIN SMALL LETTER E WITH CARON
        /* morekeys_e */ "\u0117,\u0119,\u0113,\u00E8,\u00E9,\u00EA,\u00EB,\u011B",
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        // U+0173: "Å³" LATIN SMALL LETTER U WITH OGONEK
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+016F: "Å¯" LATIN SMALL LETTER U WITH RING ABOVE
        // U+0171: "Å±" LATIN SMALL LETTER U WITH DOUBLE ACUTE
        /* morekeys_u */ "\u016B,\u0173,\u00FC,\u016B,\u00F9,\u00FA,\u00FB,\u016F,\u0171",
        /* keylabel_to_alpha */ null,
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+0131: "Ä±" LATIN SMALL LETTER DOTLESS I
        /* morekeys_i */ "\u012F,\u012B,\u00EC,\u00ED,\u00EE,\u00EF,\u0131",
        // U+0146: "Å†" LATIN SMALL LETTER N WITH CEDILLA
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u0146,\u00F1,\u0144",
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        /* morekeys_c */ "\u010D,\u00E7,\u0107",
        /* double_quotes */ "!text/double_9qm_lqm",
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+015F: "ÅŸ" LATIN SMALL LETTER S WITH CEDILLA
        /* morekeys_s */ "\u0161,\u00DF,\u015B,\u015F",
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        // U+00FF: "Ã¿" LATIN SMALL LETTER Y WITH DIAERESIS
        /* morekeys_y */ "\u00FD,\u00FF",
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        // U+017C: "Å¼" LATIN SMALL LETTER Z WITH DOT ABOVE
        // U+017A: "Åº" LATIN SMALL LETTER Z WITH ACUTE
        /* morekeys_z */ "\u017E,\u017C,\u017A",
        // U+010F: "Ä�" LATIN SMALL LETTER D WITH CARON
        /* morekeys_d */ "\u010F",
        // U+0163: "Å£" LATIN SMALL LETTER T WITH CEDILLA
        // U+0165: "Å¥" LATIN SMALL LETTER T WITH CARON
        /* morekeys_t */ "\u0163,\u0165",
        // U+013C: "Ä¼" LATIN SMALL LETTER L WITH CEDILLA
        // U+0142: "Å‚" LATIN SMALL LETTER L WITH STROKE
        // U+013A: "Äº" LATIN SMALL LETTER L WITH ACUTE
        // U+013E: "Ä¾" LATIN SMALL LETTER L WITH CARON
        /* morekeys_l */ "\u013C,\u0142,\u013A,\u013E",
        // U+0123: "Ä£" LATIN SMALL LETTER G WITH CEDILLA
        // U+011F: "ÄŸ" LATIN SMALL LETTER G WITH BREVE
        /* morekeys_g */ "\u0123,\u011F",
        /* single_angle_quotes */ null,
        /* double_angle_quotes */ null,
        // U+0157: "Å—" LATIN SMALL LETTER R WITH CEDILLA
        // U+0159: "Å™" LATIN SMALL LETTER R WITH CARON
        // U+0155: "Å•" LATIN SMALL LETTER R WITH ACUTE
        /* morekeys_r */ "\u0157,\u0159,\u0155",
        // U+0137: "Ä·" LATIN SMALL LETTER K WITH CEDILLA
        /* morekeys_k */ "\u0137",
    };

    /* Locale lv: Latvian */
    private static final String[] TEXTS_lv = {
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        /* morekeys_a */ "\u0101,\u00E0,\u00E1,\u00E2,\u00E3,\u00E4,\u00E5,\u00E6,\u0105",
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+0151: "Å‘" LATIN SMALL LETTER O WITH DOUBLE ACUTE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        /* morekeys_o */ "\u00F2,\u00F3,\u00F4,\u00F5,\u00F6,\u0153,\u0151,\u00F8",
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+011B: "Ä›" LATIN SMALL LETTER E WITH CARON
        /* morekeys_e */ "\u0113,\u0117,\u00E8,\u00E9,\u00EA,\u00EB,\u0119,\u011B",
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        // U+0173: "Å³" LATIN SMALL LETTER U WITH OGONEK
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+016F: "Å¯" LATIN SMALL LETTER U WITH RING ABOVE
        // U+0171: "Å±" LATIN SMALL LETTER U WITH DOUBLE ACUTE
        /* morekeys_u */ "\u016B,\u0173,\u00F9,\u00FA,\u00FB,\u00FC,\u016F,\u0171",
        /* keylabel_to_alpha */ null,
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+0131: "Ä±" LATIN SMALL LETTER DOTLESS I
        /* morekeys_i */ "\u012B,\u012F,\u00EC,\u00ED,\u00EE,\u00EF,\u0131",
        // U+0146: "Å†" LATIN SMALL LETTER N WITH CEDILLA
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u0146,\u00F1,\u0144",
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        /* morekeys_c */ "\u010D,\u00E7,\u0107",
        /* double_quotes */ "!text/double_9qm_lqm",
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+015F: "ÅŸ" LATIN SMALL LETTER S WITH CEDILLA
        /* morekeys_s */ "\u0161,\u00DF,\u015B,\u015F",
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        // U+00FF: "Ã¿" LATIN SMALL LETTER Y WITH DIAERESIS
        /* morekeys_y */ "\u00FD,\u00FF",
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        // U+017C: "Å¼" LATIN SMALL LETTER Z WITH DOT ABOVE
        // U+017A: "Åº" LATIN SMALL LETTER Z WITH ACUTE
        /* morekeys_z */ "\u017E,\u017C,\u017A",
        // U+010F: "Ä�" LATIN SMALL LETTER D WITH CARON
        /* morekeys_d */ "\u010F",
        // U+0163: "Å£" LATIN SMALL LETTER T WITH CEDILLA
        // U+0165: "Å¥" LATIN SMALL LETTER T WITH CARON
        /* morekeys_t */ "\u0163,\u0165",
        // U+013C: "Ä¼" LATIN SMALL LETTER L WITH CEDILLA
        // U+0142: "Å‚" LATIN SMALL LETTER L WITH STROKE
        // U+013A: "Äº" LATIN SMALL LETTER L WITH ACUTE
        // U+013E: "Ä¾" LATIN SMALL LETTER L WITH CARON
        /* morekeys_l */ "\u013C,\u0142,\u013A,\u013E",
        // U+0123: "Ä£" LATIN SMALL LETTER G WITH CEDILLA
        // U+011F: "ÄŸ" LATIN SMALL LETTER G WITH BREVE
        /* morekeys_g */ "\u0123,\u011F",
        /* single_angle_quotes */ null,
        /* double_angle_quotes */ null,
        // U+0157: "Å—" LATIN SMALL LETTER R WITH CEDILLA
        // U+0159: "Å™" LATIN SMALL LETTER R WITH CARON
        // U+0155: "Å•" LATIN SMALL LETTER R WITH ACUTE
        /* morekeys_r */ "\u0157,\u0159,\u0155",
        // U+0137: "Ä·" LATIN SMALL LETTER K WITH CEDILLA
        /* morekeys_k */ "\u0137",
    };

    /* Locale mk: Macedonian */
    private static final String[] TEXTS_mk = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0410: "Ð�" CYRILLIC CAPITAL LETTER A
        // U+0411: "Ð‘" CYRILLIC CAPITAL LETTER BE
        // U+0412: "Ð’" CYRILLIC CAPITAL LETTER VE
        /* keylabel_to_alpha */ "\u0410\u0411\u0412",
        /* morekeys_i ~ */
        null, null, null,
        /* ~ morekeys_c */
        /* double_quotes */ "!text/double_9qm_lqm",
        /* morekeys_s */ null,
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency ~ */
        null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_k */
        // U+0450: "Ñ�" CYRILLIC SMALL LETTER IE WITH GRAVE
        /* morekeys_cyrillic_ie */ "\u0450",
        /* keyspec_nordic_row1_11 ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_cyrillic_o */
        // U+045D: "Ñ�" CYRILLIC SMALL LETTER I WITH GRAVE
        /* morekeys_cyrillic_i */ "\u045D",
        // U+0455: "Ñ•" CYRILLIC SMALL LETTER DZE
        /* keyspec_south_slavic_row1_6 */ "\u0455",
        // U+045C: "Ñœ" CYRILLIC SMALL LETTER KJE
        /* keyspec_south_slavic_row2_11 */ "\u045C",
        // U+0437: "Ð·" CYRILLIC SMALL LETTER ZE
        /* keyspec_south_slavic_row3_1 */ "\u0437",
        // U+0453: "Ñ“" CYRILLIC SMALL LETTER GJE
        /* keyspec_south_slavic_row3_8 */ "\u0453",
    };

    /* Locale ml_IN: Malayalam (India) */
    private static final String[] TEXTS_ml_IN = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0D05: "à´…" MALAYALAM LETTER A
        /* keylabel_to_alpha */ "\u0D05",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+20B9: "â‚¹" INDIAN RUPEE SIGN
        /* keyspec_currency */ "\u20B9",
    };

    /* Locale mn_MN: Mongolian (Mongolia) */
    private static final String[] TEXTS_mn_MN = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0410: "Ð�" CYRILLIC CAPITAL LETTER A
        // U+0411: "Ð‘" CYRILLIC CAPITAL LETTER BE
        // U+0412: "Ð’" CYRILLIC CAPITAL LETTER VE
        /* keylabel_to_alpha */ "\u0410\u0411\u0412",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+20AE: "â‚®" TUGRIK SIGN
        /* keyspec_currency */ "\u20AE",
    };

    /* Locale mr_IN: Marathi (India) */
    private static final String[] TEXTS_mr_IN = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0915: "à¤•" DEVANAGARI LETTER KA
        // U+0916: "à¤–" DEVANAGARI LETTER KHA
        // U+0917: "à¤—" DEVANAGARI LETTER GA
        /* keylabel_to_alpha */ "\u0915\u0916\u0917",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+20B9: "â‚¹" INDIAN RUPEE SIGN
        /* keyspec_currency */ "\u20B9",
        /* morekeys_y ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null,
        /* ~ morekeys_cyrillic_soft_sign */
        // U+0967: "à¥§" DEVANAGARI DIGIT ONE
        /* keyspec_symbols_1 */ "\u0967",
        // U+0968: "à¥¨" DEVANAGARI DIGIT TWO
        /* keyspec_symbols_2 */ "\u0968",
        // U+0969: "à¥©" DEVANAGARI DIGIT THREE
        /* keyspec_symbols_3 */ "\u0969",
        // U+096A: "à¥ª" DEVANAGARI DIGIT FOUR
        /* keyspec_symbols_4 */ "\u096A",
        // U+096B: "à¥«" DEVANAGARI DIGIT FIVE
        /* keyspec_symbols_5 */ "\u096B",
        // U+096C: "à¥¬" DEVANAGARI DIGIT SIX
        /* keyspec_symbols_6 */ "\u096C",
        // U+096D: "à¥­" DEVANAGARI DIGIT SEVEN
        /* keyspec_symbols_7 */ "\u096D",
        // U+096E: "à¥®" DEVANAGARI DIGIT EIGHT
        /* keyspec_symbols_8 */ "\u096E",
        // U+096F: "à¥¯" DEVANAGARI DIGIT NINE
        /* keyspec_symbols_9 */ "\u096F",
        // U+0966: "à¥¦" DEVANAGARI DIGIT ZERO
        /* keyspec_symbols_0 */ "\u0966",
        // Label for "switch to symbols" key.
        /* keylabel_to_symbol */ "?\u0967\u0968\u0969",
        /* additional_morekeys_symbols_1 */ "1",
        /* additional_morekeys_symbols_2 */ "2",
        /* additional_morekeys_symbols_3 */ "3",
        /* additional_morekeys_symbols_4 */ "4",
        /* additional_morekeys_symbols_5 */ "5",
        /* additional_morekeys_symbols_6 */ "6",
        /* additional_morekeys_symbols_7 */ "7",
        /* additional_morekeys_symbols_8 */ "8",
        /* additional_morekeys_symbols_9 */ "9",
        /* additional_morekeys_symbols_0 */ "0",
    };

    /* Locale nb: Norwegian BokmÃ¥l */
    private static final String[] TEXTS_nb = {
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u00E5,\u00E6,\u00E4,\u00E0,\u00E1,\u00E2,\u00E3,\u0101",
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F8,\u00F6,\u00F4,\u00F2,\u00F3,\u00F5,\u0153,\u014D",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u00E8,\u00EA,\u00EB,\u0119,\u0117,\u0113",
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FC,\u00FB,\u00F9,\u00FA,\u016B",
        /* keylabel_to_alpha ~ */
        null, null, null, null,
        /* ~ morekeys_c */
        /* double_quotes */ "!text/double_9qm_rqm",
        /* morekeys_s */ null,
        /* single_quotes */ "!text/single_9qm_rqm",
        /* keyspec_currency ~ */
        null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_cyrillic_ie */
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        /* keyspec_nordic_row1_11 */ "\u00E5",
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        /* keyspec_nordic_row2_10 */ "\u00F8",
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        /* keyspec_nordic_row2_11 */ "\u00E6",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        /* morekeys_nordic_row2_10 */ "\u00F6",
        /* keyspec_east_slavic_row1_9 ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_tablet_period */
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        /* morekeys_nordic_row2_11 */ "\u00E4",
    };

    /* Locale ne_NP: Nepali (Nepal) */
    private static final String[] TEXTS_ne_NP = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0915: "à¤•" DEVANAGARI LETTER KA
        // U+0916: "à¤–" DEVANAGARI LETTER KHA
        // U+0917: "à¤—" DEVANAGARI LETTER GA
        /* keylabel_to_alpha */ "\u0915\u0916\u0917",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+0930/U+0941/U+002E "à¤°à¥�." NEPALESE RUPEE SIGN
        /* keyspec_currency */ "\u0930\u0941.",
        /* morekeys_y ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null,
        /* ~ morekeys_cyrillic_soft_sign */
        // U+0967: "à¥§" DEVANAGARI DIGIT ONE
        /* keyspec_symbols_1 */ "\u0967",
        // U+0968: "à¥¨" DEVANAGARI DIGIT TWO
        /* keyspec_symbols_2 */ "\u0968",
        // U+0969: "à¥©" DEVANAGARI DIGIT THREE
        /* keyspec_symbols_3 */ "\u0969",
        // U+096A: "à¥ª" DEVANAGARI DIGIT FOUR
        /* keyspec_symbols_4 */ "\u096A",
        // U+096B: "à¥«" DEVANAGARI DIGIT FIVE
        /* keyspec_symbols_5 */ "\u096B",
        // U+096C: "à¥¬" DEVANAGARI DIGIT SIX
        /* keyspec_symbols_6 */ "\u096C",
        // U+096D: "à¥­" DEVANAGARI DIGIT SEVEN
        /* keyspec_symbols_7 */ "\u096D",
        // U+096E: "à¥®" DEVANAGARI DIGIT EIGHT
        /* keyspec_symbols_8 */ "\u096E",
        // U+096F: "à¥¯" DEVANAGARI DIGIT NINE
        /* keyspec_symbols_9 */ "\u096F",
        // U+0966: "à¥¦" DEVANAGARI DIGIT ZERO
        /* keyspec_symbols_0 */ "\u0966",
        // Label for "switch to symbols" key.
        /* keylabel_to_symbol */ "?\u0967\u0968\u0969",
        /* additional_morekeys_symbols_1 */ "1",
        /* additional_morekeys_symbols_2 */ "2",
        /* additional_morekeys_symbols_3 */ "3",
        /* additional_morekeys_symbols_4 */ "4",
        /* additional_morekeys_symbols_5 */ "5",
        /* additional_morekeys_symbols_6 */ "6",
        /* additional_morekeys_symbols_7 */ "7",
        /* additional_morekeys_symbols_8 */ "8",
        /* additional_morekeys_symbols_9 */ "9",
        /* additional_morekeys_symbols_0 */ "0",
        /* morekeys_tablet_period */ "!autoColumnOrder!8,.,\\,,',#,),(,/,;,@,:,-,\",+,\\%,&",
        /* morekeys_nordic_row2_11 ~ */
        null, null, null,
        /* ~ keyspec_tablet_comma */
        // U+0964: "à¥¤" DEVANAGARI DANDA
        /* keyspec_period */ "\u0964",
        /* morekeys_period */ "!autoColumnOrder!9,.,\\,,?,!,#,),(,/,;,',@,:,-,\",+,\\%,&",
        /* keyspec_tablet_period */ "\u0964",
    };

    /* Locale nl: Dutch */
    private static final String[] TEXTS_nl = {
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u00E1,\u00E4,\u00E2,\u00E0,\u00E6,\u00E3,\u00E5,\u0101",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F3,\u00F6,\u00F4,\u00F2,\u00F5,\u0153,\u00F8,\u014D",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u00EB,\u00EA,\u00E8,\u0119,\u0117,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FC,\u00FB,\u00F9,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        // U+0133: "Ä³" LATIN SMALL LIGATURE IJ
        /* morekeys_i */ "\u00ED,\u00EF,\u00EC,\u00EE,\u012F,\u012B,\u0133",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u00F1,\u0144",
        /* morekeys_c */ null,
        /* double_quotes */ "!text/double_9qm_rqm",
        /* morekeys_s */ null,
        /* single_quotes */ "!text/single_9qm_rqm",
        /* keyspec_currency */ null,
        // U+0133: "Ä³" LATIN SMALL LIGATURE IJ
        /* morekeys_y */ "\u0133",
    };

    /* Locale pl: Polish */
    private static final String[] TEXTS_pl = {
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u0105,\u00E1,\u00E0,\u00E2,\u00E4,\u00E6,\u00E3,\u00E5,\u0101",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F3,\u00F6,\u00F4,\u00F2,\u00F5,\u0153,\u00F8,\u014D",
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u0119,\u00E8,\u00E9,\u00EA,\u00EB,\u0117,\u0113",
        /* morekeys_u ~ */
        null, null, null,
        /* ~ morekeys_i */
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        /* morekeys_n */ "\u0144,\u00F1",
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        /* morekeys_c */ "\u0107,\u00E7,\u010D",
        /* double_quotes */ "!text/double_9qm_rqm",
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        /* morekeys_s */ "\u015B,\u00DF,\u0161",
        /* single_quotes */ "!text/single_9qm_rqm",
        /* keyspec_currency */ null,
        /* morekeys_y */ null,
        // U+017C: "Å¼" LATIN SMALL LETTER Z WITH DOT ABOVE
        // U+017A: "Åº" LATIN SMALL LETTER Z WITH ACUTE
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        /* morekeys_z */ "\u017C,\u017A,\u017E",
        /* morekeys_d */ null,
        /* morekeys_t */ null,
        // U+0142: "Å‚" LATIN SMALL LETTER L WITH STROKE
        /* morekeys_l */ "\u0142",
    };

    /* Locale pt: Portuguese */
    private static final String[] TEXTS_pt = {
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00AA: "Âª" FEMININE ORDINAL INDICATOR
        /* morekeys_a */ "\u00E1,\u00E3,\u00E0,\u00E2,\u00E4,\u00E5,\u00E6,\u00AA",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+00BA: "Âº" MASCULINE ORDINAL INDICATOR
        /* morekeys_o */ "\u00F3,\u00F5,\u00F4,\u00F2,\u00F6,\u0153,\u00F8,\u014D,\u00BA",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        /* morekeys_e */ "\u00E9,\u00EA,\u00E8,\u0119,\u0117,\u0113,\u00EB",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FC,\u00F9,\u00FB,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u00ED,\u00EE,\u00EC,\u00EF,\u012F,\u012B",
        /* morekeys_n */ null,
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        /* morekeys_c */ "\u00E7,\u010D,\u0107",
    };

    /* Locale rm: Raeto-Romance */
    private static final String[] TEXTS_rm = {
        /* morekeys_a */ null,
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        /* morekeys_o */ "\u00F2,\u00F3,\u00F6,\u00F4,\u00F5,\u0153,\u00F8",
    };

    /* Locale ro: Romanian */
    private static final String[] TEXTS_ro = {
        // U+0103: "Äƒ" LATIN SMALL LETTER A WITH BREVE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u0103,\u00E2,\u00E3,\u00E0,\u00E1,\u00E4,\u00E6,\u00E5,\u0101",
        /* morekeys_o ~ */
        null, null, null, null,
        /* ~ keylabel_to_alpha */
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u00EE,\u00EF,\u00EC,\u00ED,\u012F,\u012B",
        /* morekeys_n */ null,
        /* morekeys_c */ null,
        /* double_quotes */ "!text/double_9qm_rqm",
        // U+0219: "È™" LATIN SMALL LETTER S WITH COMMA BELOW
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        /* morekeys_s */ "\u0219,\u00DF,\u015B,\u0161",
        /* single_quotes */ "!text/single_9qm_rqm",
        /* keyspec_currency ~ */
        null, null, null, null,
        /* ~ morekeys_d */
        // U+021B: "È›" LATIN SMALL LETTER T WITH COMMA BELOW
        /* morekeys_t */ "\u021B",
    };

    /* Locale ru: Russian */
    private static final String[] TEXTS_ru = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0410: "Ð�" CYRILLIC CAPITAL LETTER A
        // U+0411: "Ð‘" CYRILLIC CAPITAL LETTER BE
        // U+0412: "Ð’" CYRILLIC CAPITAL LETTER VE
        /* keylabel_to_alpha */ "\u0410\u0411\u0412",
        /* morekeys_i ~ */
        null, null, null,
        /* ~ morekeys_c */
        /* double_quotes */ "!text/double_9qm_lqm",
        /* morekeys_s */ null,
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency ~ */
        null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_k */
        // U+0451: "Ñ‘" CYRILLIC SMALL LETTER IO
        /* morekeys_cyrillic_ie */ "\u0451",
        /* keyspec_nordic_row1_11 ~ */
        null, null, null, null,
        /* ~ morekeys_nordic_row2_10 */
        // U+0449: "Ñ‰" CYRILLIC SMALL LETTER SHCHA
        /* keyspec_east_slavic_row1_9 */ "\u0449",
        // U+044B: "Ñ‹" CYRILLIC SMALL LETTER YERU
        /* keyspec_east_slavic_row2_2 */ "\u044B",
        // U+044D: "Ñ�" CYRILLIC SMALL LETTER E
        /* keyspec_east_slavic_row2_11 */ "\u044D",
        // U+0438: "Ð¸" CYRILLIC SMALL LETTER I
        /* keyspec_east_slavic_row3_5 */ "\u0438",
        // U+044A: "ÑŠ" CYRILLIC SMALL LETTER HARD SIGN
        /* morekeys_cyrillic_soft_sign */ "\u044A",
    };

    /* Locale si_LK: Sinhalese (Sri Lanka) */
    private static final String[] TEXTS_si_LK = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0D85: "à¶…" SINHALA LETTER AYANNA
        // U+0D86: "à¶†" SINHALA LETTER AAYANNA
        /* keylabel_to_alpha */ "\u0D85,\u0D86",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+0DBB/U+0DD4: "à¶»à·”" SINHALA LETTER RAYANNA/SINHALA VOWEL SIGN KETTI PAA-PILLA
        /* keyspec_currency */ "\u0DBB\u0DD4",
    };

    /* Locale sk: Slovak */
    private static final String[] TEXTS_sk = {
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        /* morekeys_a */ "\u00E1,\u00E4,\u0101,\u00E0,\u00E2,\u00E3,\u00E5,\u00E6,\u0105",
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+0151: "Å‘" LATIN SMALL LETTER O WITH DOUBLE ACUTE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        /* morekeys_o */ "\u00F4,\u00F3,\u00F6,\u00F2,\u00F5,\u0153,\u0151,\u00F8",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+011B: "Ä›" LATIN SMALL LETTER E WITH CARON
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        /* morekeys_e */ "\u00E9,\u011B,\u0113,\u0117,\u00E8,\u00EA,\u00EB,\u0119",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+016F: "Å¯" LATIN SMALL LETTER U WITH RING ABOVE
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        // U+0173: "Å³" LATIN SMALL LETTER U WITH OGONEK
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+0171: "Å±" LATIN SMALL LETTER U WITH DOUBLE ACUTE
        /* morekeys_u */ "\u00FA,\u016F,\u00FC,\u016B,\u0173,\u00F9,\u00FB,\u0171",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+0131: "Ä±" LATIN SMALL LETTER DOTLESS I
        /* morekeys_i */ "\u00ED,\u012B,\u012F,\u00EC,\u00EE,\u00EF,\u0131",
        // U+0148: "Åˆ" LATIN SMALL LETTER N WITH CARON
        // U+0146: "Å†" LATIN SMALL LETTER N WITH CEDILLA
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u0148,\u0146,\u00F1,\u0144",
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        /* morekeys_c */ "\u010D,\u00E7,\u0107",
        /* double_quotes */ "!text/double_9qm_lqm",
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+015F: "ÅŸ" LATIN SMALL LETTER S WITH CEDILLA
        /* morekeys_s */ "\u0161,\u00DF,\u015B,\u015F",
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        // U+00FF: "Ã¿" LATIN SMALL LETTER Y WITH DIAERESIS
        /* morekeys_y */ "\u00FD,\u00FF",
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        // U+017C: "Å¼" LATIN SMALL LETTER Z WITH DOT ABOVE
        // U+017A: "Åº" LATIN SMALL LETTER Z WITH ACUTE
        /* morekeys_z */ "\u017E,\u017C,\u017A",
        // U+010F: "Ä�" LATIN SMALL LETTER D WITH CARON
        /* morekeys_d */ "\u010F",
        // U+0165: "Å¥" LATIN SMALL LETTER T WITH CARON
        // U+0163: "Å£" LATIN SMALL LETTER T WITH CEDILLA
        /* morekeys_t */ "\u0165,\u0163",
        // U+013E: "Ä¾" LATIN SMALL LETTER L WITH CARON
        // U+013A: "Äº" LATIN SMALL LETTER L WITH ACUTE
        // U+013C: "Ä¼" LATIN SMALL LETTER L WITH CEDILLA
        // U+0142: "Å‚" LATIN SMALL LETTER L WITH STROKE
        /* morekeys_l */ "\u013E,\u013A,\u013C,\u0142",
        // U+0123: "Ä£" LATIN SMALL LETTER G WITH CEDILLA
        // U+011F: "ÄŸ" LATIN SMALL LETTER G WITH BREVE
        /* morekeys_g */ "\u0123,\u011F",
        /* single_angle_quotes */ "!text/single_raqm_laqm",
        /* double_angle_quotes */ "!text/double_raqm_laqm",
        // U+0155: "Å•" LATIN SMALL LETTER R WITH ACUTE
        // U+0159: "Å™" LATIN SMALL LETTER R WITH CARON
        // U+0157: "Å—" LATIN SMALL LETTER R WITH CEDILLA
        /* morekeys_r */ "\u0155,\u0159,\u0157",
        // U+0137: "Ä·" LATIN SMALL LETTER K WITH CEDILLA
        /* morekeys_k */ "\u0137",
    };

    /* Locale sl: Slovenian */
    private static final String[] TEXTS_sl = {
        /* morekeys_a ~ */
        null, null, null, null, null, null, null,
        /* ~ morekeys_n */
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        /* morekeys_c */ "\u010D,\u0107",
        /* double_quotes */ "!text/double_9qm_lqm",
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        /* morekeys_s */ "\u0161",
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency */ null,
        /* morekeys_y */ null,
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        /* morekeys_z */ "\u017E",
        // U+0111: "Ä‘" LATIN SMALL LETTER D WITH STROKE
        /* morekeys_d */ "\u0111",
        /* morekeys_t ~ */
        null, null, null,
        /* ~ morekeys_g */
        /* single_angle_quotes */ "!text/single_raqm_laqm",
        /* double_angle_quotes */ "!text/double_raqm_laqm",
    };

    /* Locale sr: Serbian */
    private static final String[] TEXTS_sr = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // END: More keys definitions for Serbian (Cyrillic)
        // Label for "switch to alphabetic" key.
        // U+0410: "Ð�" CYRILLIC CAPITAL LETTER A
        // U+0411: "Ð‘" CYRILLIC CAPITAL LETTER BE
        // U+0412: "Ð’" CYRILLIC CAPITAL LETTER VE
        /* keylabel_to_alpha */ "\u0410\u0411\u0412",
        /* morekeys_i ~ */
        null, null, null,
        /* ~ morekeys_c */
        /* double_quotes */ "!text/double_9qm_lqm",
        /* morekeys_s */ null,
        /* single_quotes */ "!text/single_9qm_lqm",
        /* keyspec_currency ~ */
        null, null, null, null, null, null, null,
        /* ~ morekeys_g */
        /* single_angle_quotes */ "!text/single_raqm_laqm",
        /* double_angle_quotes */ "!text/double_raqm_laqm",
        /* morekeys_r */ null,
        /* morekeys_k */ null,
        // U+0450: "Ñ�" CYRILLIC SMALL LETTER IE WITH GRAVE
        /* morekeys_cyrillic_ie */ "\u0450",
        /* keyspec_nordic_row1_11 ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_cyrillic_o */
        // U+045D: "Ñ�" CYRILLIC SMALL LETTER I WITH GRAVE
        /* morekeys_cyrillic_i */ "\u045D",
        // TODO: Move these to sr-Latn once we can handle IETF language tag with script name specified.
        // BEGIN: More keys definitions for Serbian (Latin)
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // <string name="morekeys_s">&#x0161;,&#x00DF;,&#x015B;</string>
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // <string name="morekeys_c">&#x010D;,&#x00E7;,&#x0107;</string>
        // U+010F: "Ä�" LATIN SMALL LETTER D WITH CARON
        // <string name="morekeys_d">&#x010F;</string>
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        // U+017A: "Åº" LATIN SMALL LETTER Z WITH ACUTE
        // U+017C: "Å¼" LATIN SMALL LETTER Z WITH DOT ABOVE
        // <string name="morekeys_z">&#x017E;,&#x017A;,&#x017C;</string>
        // END: More keys definitions for Serbian (Latin)
        // BEGIN: More keys definitions for Serbian (Cyrillic)
        // U+0437: "Ð·" CYRILLIC SMALL LETTER ZE
        /* keyspec_south_slavic_row1_6 */ "\u0437",
        // U+045B: "Ñ›" CYRILLIC SMALL LETTER TSHE
        /* keyspec_south_slavic_row2_11 */ "\u045B",
        // U+0455: "Ñ•" CYRILLIC SMALL LETTER DZE
        /* keyspec_south_slavic_row3_1 */ "\u0455",
        // U+0452: "Ñ’" CYRILLIC SMALL LETTER DJE
        /* keyspec_south_slavic_row3_8 */ "\u0452",
    };

    /* Locale sr_ZZ: Serbian (ZZ) */
    private static final String[] TEXTS_sr_ZZ = {
        /* morekeys_a */ null,
        /* morekeys_o */ null,
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        /* morekeys_e */ "\u00E8",
        /* morekeys_u */ null,
        /* keylabel_to_alpha */ null,
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        /* morekeys_i */ "\u00EC",
        /* morekeys_n */ null,
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        /* morekeys_c */ "\u010D,\u0107,%",
        /* double_quotes */ null,
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        /* morekeys_s */ "\u0161,%",
        /* single_quotes ~ */
        null, null, null,
        /* ~ morekeys_y */
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        /* morekeys_z */ "\u017E,%",
        // U+0111: "Ä‘" LATIN SMALL LETTER D WITH STROKE
        /* morekeys_d */ "\u0111,%",
        /* morekeys_t ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null,
        /* ~ morekeys_symbols_percent */
        /* label_go_key */ "Idi",
        /* label_send_key */ "\u0160alji",
        /* label_next_key */ "Sled",
        /* label_done_key */ "Gotov",
        /* label_search_key */ "Tra\u017Ei",
        /* label_previous_key */ "Preth",
        /* label_pause_key */ "Pauza",
        /* label_wait_key */ "\u010Cekaj",
    };

    /* Locale sv: Swedish */
    private static final String[] TEXTS_sv = {
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        /* morekeys_a */ "\u00E4,\u00E5,\u00E6,\u00E1,\u00E0,\u00E2,\u0105,\u00E3",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F6,\u00F8,\u0153,\u00F3,\u00F2,\u00F4,\u00F5,\u014D",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        /* morekeys_e */ "\u00E9,\u00E8,\u00EA,\u00EB,\u0119",
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FC,\u00FA,\u00F9,\u00FB,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        /* morekeys_i */ "\u00ED,\u00EC,\u00EE,\u00EF",
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0148: "Åˆ" LATIN SMALL LETTER N WITH CARON
        /* morekeys_n */ "\u0144,\u00F1,\u0148",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        /* morekeys_c */ "\u00E7,\u0107,\u010D",
        /* double_quotes */ null,
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        // U+015F: "ÅŸ" LATIN SMALL LETTER S WITH CEDILLA
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        /* morekeys_s */ "\u015B,\u0161,\u015F,\u00DF",
        /* single_quotes */ null,
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        // U+00FF: "Ã¿" LATIN SMALL LETTER Y WITH DIAERESIS
        /* morekeys_y */ "\u00FD,\u00FF",
        // U+017A: "Åº" LATIN SMALL LETTER Z WITH ACUTE
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        // U+017C: "Å¼" LATIN SMALL LETTER Z WITH DOT ABOVE
        /* morekeys_z */ "\u017A,\u017E,\u017C",
        // U+00F0: "Ã°" LATIN SMALL LETTER ETH
        // U+010F: "Ä�" LATIN SMALL LETTER D WITH CARON
        /* morekeys_d */ "\u00F0,\u010F",
        // U+0165: "Å¥" LATIN SMALL LETTER T WITH CARON
        // U+00FE: "Ã¾" LATIN SMALL LETTER THORN
        /* morekeys_t */ "\u0165,\u00FE",
        // U+0142: "Å‚" LATIN SMALL LETTER L WITH STROKE
        /* morekeys_l */ "\u0142",
        /* morekeys_g */ null,
        /* single_angle_quotes */ "!text/single_raqm_laqm",
        /* double_angle_quotes */ "!text/double_raqm_laqm",
        // U+0159: "Å™" LATIN SMALL LETTER R WITH CARON
        /* morekeys_r */ "\u0159",
        /* morekeys_k */ null,
        /* morekeys_cyrillic_ie */ null,
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        /* keyspec_nordic_row1_11 */ "\u00E5",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        /* keyspec_nordic_row2_10 */ "\u00F6",
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        /* keyspec_nordic_row2_11 */ "\u00E4",
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        /* morekeys_nordic_row2_10 */ "\u00F8,\u0153",
        /* keyspec_east_slavic_row1_9 ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_tablet_period */
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        /* morekeys_nordic_row2_11 */ "\u00E6",
    };

    /* Locale sw: Swahili */
    private static final String[] TEXTS_sw = {
        // This is the same as English except morekeys_g.
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u00E0,\u00E1,\u00E2,\u00E4,\u00E6,\u00E3,\u00E5,\u0101",
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        /* morekeys_o */ "\u00F4,\u00F6,\u00F2,\u00F3,\u0153,\u00F8,\u014D,\u00F5",
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E8,\u00E9,\u00EA,\u00EB,\u0113",
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FB,\u00FC,\u00F9,\u00FA,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        /* morekeys_i */ "\u00EE,\u00EF,\u00ED,\u012B,\u00EC",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        /* morekeys_n */ "\u00F1",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        /* morekeys_c */ "\u00E7",
        /* double_quotes */ null,
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        /* morekeys_s */ "\u00DF",
        /* single_quotes ~ */
        null, null, null, null, null, null, null,
        /* ~ morekeys_l */
        /* morekeys_g */ "g\'",
    };

    /* Locale ta_IN: Tamil (India) */
    private static final String[] TEXTS_ta_IN = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0BA4: "à®¤" TAMIL LETTER TA
        // U+0BAE/U+0BBF: "à®®à®¿" TAMIL LETTER MA/TAMIL VOWEL SIGN I
        // U+0BB4/U+0BCD: "à®´à¯�" TAMIL LETTER LLLA/TAMIL SIGN VIRAMA
        /* keylabel_to_alpha */ "\u0BA4\u0BAE\u0BBF\u0BB4\u0BCD",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+0BF9: "à¯¹" TAMIL RUPEE SIGN
        /* keyspec_currency */ "\u0BF9",
    };

    /* Locale ta_LK: Tamil (Sri Lanka) */
    private static final String[] TEXTS_ta_LK = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0BA4: "à®¤" TAMIL LETTER TA
        // U+0BAE/U+0BBF: "à®®à®¿" TAMIL LETTER MA/TAMIL VOWEL SIGN I
        // U+0BB4/U+0BCD: "à®´à¯�" TAMIL LETTER LLLA/TAMIL SIGN VIRAMA
        /* keylabel_to_alpha */ "\u0BA4\u0BAE\u0BBF\u0BB4\u0BCD",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+0DBB/U+0DD4: "à¶»à·”" SINHALA LETTER RAYANNA/SINHALA VOWEL SIGN KETTI PAA-PILLA
        /* keyspec_currency */ "\u0DBB\u0DD4",
    };

    /* Locale ta_SG: Tamil (Singapore) */
    private static final String[] TEXTS_ta_SG = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0BA4: "à®¤" TAMIL LETTER TA
        // U+0BAE/U+0BBF: "à®®à®¿" TAMIL LETTER MA/TAMIL VOWEL SIGN I
        // U+0BB4/U+0BCD: "à®´à¯�" TAMIL LETTER LLLA/TAMIL SIGN VIRAMA
        /* keylabel_to_alpha */ "\u0BA4\u0BAE\u0BBF\u0BB4\u0BCD",
    };

    /* Locale te_IN: Telugu (India) */
    private static final String[] TEXTS_te_IN = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0C05: "à°…" TELUGU LETTER A
        // U+0C06: "à°†" TELUGU LETTER AA
        // U+0C07: "à°‡" TELUGU LETTER I
        /* keylabel_to_alpha */ "\u0C05\u0C06\u0C07",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+20B9: "â‚¹" INDIAN RUPEE SIGN
        /* keyspec_currency */ "\u20B9",
    };

    /* Locale th: Thai */
    private static final String[] TEXTS_th = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0E01: "à¸�" THAI CHARACTER KO KAI
        // U+0E02: "à¸‚" THAI CHARACTER KHO KHAI
        // U+0E04: "à¸„" THAI CHARACTER KHO KHWAI
        /* keylabel_to_alpha */ "\u0E01\u0E02\u0E04",
        /* morekeys_i ~ */
        null, null, null, null, null, null,
        /* ~ single_quotes */
        // U+0E3F: "à¸¿" THAI CURRENCY SYMBOL BAHT
        /* keyspec_currency */ "\u0E3F",
    };

    /* Locale tl: Tagalog */
    private static final String[] TEXTS_tl = {
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+00AA: "Âª" FEMININE ORDINAL INDICATOR
        /* morekeys_a */ "\u00E1,\u00E0,\u00E4,\u00E2,\u00E3,\u00E5,\u0105,\u00E6,\u0101,\u00AA",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+00BA: "Âº" MASCULINE ORDINAL INDICATOR
        /* morekeys_o */ "\u00F3,\u00F2,\u00F6,\u00F4,\u00F5,\u00F8,\u0153,\u014D,\u00BA",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u00E8,\u00EB,\u00EA,\u0119,\u0117,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FC,\u00F9,\u00FB,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u00ED,\u00EF,\u00EC,\u00EE,\u012F,\u012B",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        /* morekeys_n */ "\u00F1,\u0144",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        /* morekeys_c */ "\u00E7,\u0107,\u010D",
    };

    /* Locale tr: Turkish */
    private static final String[] TEXTS_tr = {
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        /* morekeys_a */ "\u00E2,\u00E4,\u00E1",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F6,\u00F4,\u0153,\u00F2,\u00F3,\u00F5,\u00F8,\u014D",
        // U+0259: "É™" LATIN SMALL LETTER SCHWA
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        /* morekeys_e */ "\u0259,\u00E9",
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FC,\u00FB,\u00F9,\u00FA,\u016B",
        /* keylabel_to_alpha */ null,
        // U+0131: "Ä±" LATIN SMALL LETTER DOTLESS I
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u0131,\u00EE,\u00EF,\u00EC,\u00ED,\u012F,\u012B",
        // U+0148: "Åˆ" LATIN SMALL LETTER N WITH CARON
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        /* morekeys_n */ "\u0148,\u00F1",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        /* morekeys_c */ "\u00E7,\u0107,\u010D",
        /* double_quotes */ null,
        // U+015F: "ÅŸ" LATIN SMALL LETTER S WITH CEDILLA
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        /* morekeys_s */ "\u015F,\u00DF,\u015B,\u0161",
        /* single_quotes */ null,
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        /* morekeys_y */ "\u00FD",
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        /* morekeys_z */ "\u017E",
        /* morekeys_d ~ */
        null, null, null,
        /* ~ morekeys_l */
        // U+011F: "ÄŸ" LATIN SMALL LETTER G WITH BREVE
        /* morekeys_g */ "\u011F",
    };

    /* Locale uk: Ukrainian */
    private static final String[] TEXTS_uk = {
        /* morekeys_a ~ */
        null, null, null, null,
        /* ~ morekeys_u */
        // Label for "switch to alphabetic" key.
        // U+0410: "Ð�" CYRILLIC CAPITAL LETTER A
        // U+0411: "Ð‘" CYRILLIC CAPITAL LETTER BE
        // U+0412: "Ð’" CYRILLIC CAPITAL LETTER VE
        /* keylabel_to_alpha */ "\u0410\u0411\u0412",
        /* morekeys_i ~ */
        null, null, null,
        /* ~ morekeys_c */
        /* double_quotes */ "!text/double_9qm_lqm",
        /* morekeys_s */ null,
        /* single_quotes */ "!text/single_9qm_lqm",
        // U+20B4: "â‚´" HRYVNIA SIGN
        /* keyspec_currency */ "\u20B4",
        /* morekeys_y ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_nordic_row2_10 */
        // U+0449: "Ñ‰" CYRILLIC SMALL LETTER SHCHA
        /* keyspec_east_slavic_row1_9 */ "\u0449",
        // U+0456: "Ñ–" CYRILLIC SMALL LETTER BYELORUSSIAN-UKRAINIAN I
        /* keyspec_east_slavic_row2_2 */ "\u0456",
        // U+0454: "Ñ”" CYRILLIC SMALL LETTER UKRAINIAN IE
        /* keyspec_east_slavic_row2_11 */ "\u0454",
        // U+0438: "Ð¸" CYRILLIC SMALL LETTER I
        /* keyspec_east_slavic_row3_5 */ "\u0438",
        // U+044A: "ÑŠ" CYRILLIC SMALL LETTER HARD SIGN
        /* morekeys_cyrillic_soft_sign */ "\u044A",
        /* keyspec_symbols_1 ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null,
        /* ~ morekeys_w */
        // U+0457: "Ñ—" CYRILLIC SMALL LETTER YI
        /* morekeys_east_slavic_row2_2 */ "\u0457",
        /* morekeys_cyrillic_u */ null,
        /* morekeys_cyrillic_en */ null,
        // U+0491: "Ò‘" CYRILLIC SMALL LETTER GHE WITH UPTURN
        /* morekeys_cyrillic_ghe */ "\u0491",
    };

    /* Locale uz_UZ: Uzbek (Uzbekistan) */
    private static final String[] TEXTS_uz_UZ = {
        // This is the same as Turkish
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        /* morekeys_a */ "\u00E2,\u00E4,\u00E1",
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        /* morekeys_o */ "\u00F6,\u00F4,\u0153,\u00F2,\u00F3,\u00F5,\u00F8,\u014D",
        // U+0259: "É™" LATIN SMALL LETTER SCHWA
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        /* morekeys_e */ "\u0259,\u00E9",
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FC,\u00FB,\u00F9,\u00FA,\u016B",
        /* keylabel_to_alpha */ null,
        // U+0131: "Ä±" LATIN SMALL LETTER DOTLESS I
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        /* morekeys_i */ "\u0131,\u00EE,\u00EF,\u00EC,\u00ED,\u012F,\u012B",
        // U+0148: "Åˆ" LATIN SMALL LETTER N WITH CARON
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        /* morekeys_n */ "\u0148,\u00F1",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        /* morekeys_c */ "\u00E7,\u0107,\u010D",
        /* double_quotes */ null,
        // U+015F: "ÅŸ" LATIN SMALL LETTER S WITH CEDILLA
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        /* morekeys_s */ "\u015F,\u00DF,\u015B,\u0161",
        /* single_quotes */ null,
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        /* morekeys_y */ "\u00FD",
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        /* morekeys_z */ "\u017E",
        /* morekeys_d ~ */
        null, null, null,
        /* ~ morekeys_l */
        // U+011F: "ÄŸ" LATIN SMALL LETTER G WITH BREVE
        /* morekeys_g */ "\u011F",
    };

    /* Locale vi: Vietnamese */
    private static final String[] TEXTS_vi = {
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+1EA3: "áº£" LATIN SMALL LETTER A WITH HOOK ABOVE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+1EA1: "áº¡" LATIN SMALL LETTER A WITH DOT BELOW
        // U+0103: "Äƒ" LATIN SMALL LETTER A WITH BREVE
        // U+1EB1: "áº±" LATIN SMALL LETTER A WITH BREVE AND GRAVE
        // U+1EAF: "áº¯" LATIN SMALL LETTER A WITH BREVE AND ACUTE
        // U+1EB3: "áº³" LATIN SMALL LETTER A WITH BREVE AND HOOK ABOVE
        // U+1EB5: "áºµ" LATIN SMALL LETTER A WITH BREVE AND TILDE
        // U+1EB7: "áº·" LATIN SMALL LETTER A WITH BREVE AND DOT BELOW
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+1EA7: "áº§" LATIN SMALL LETTER A WITH CIRCUMFLEX AND GRAVE
        // U+1EA5: "áº¥" LATIN SMALL LETTER A WITH CIRCUMFLEX AND ACUTE
        // U+1EA9: "áº©" LATIN SMALL LETTER A WITH CIRCUMFLEX AND HOOK ABOVE
        // U+1EAB: "áº«" LATIN SMALL LETTER A WITH CIRCUMFLEX AND TILDE
        // U+1EAD: "áº­" LATIN SMALL LETTER A WITH CIRCUMFLEX AND DOT BELOW
        /* morekeys_a */ "\u00E0,\u00E1,\u1EA3,\u00E3,\u1EA1,\u0103,\u1EB1,\u1EAF,\u1EB3,\u1EB5,\u1EB7,\u00E2,\u1EA7,\u1EA5,\u1EA9,\u1EAB,\u1EAD",
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+1ECF: "á»�" LATIN SMALL LETTER O WITH HOOK ABOVE
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+1ECD: "á»�" LATIN SMALL LETTER O WITH DOT BELOW
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+1ED3: "á»“" LATIN SMALL LETTER O WITH CIRCUMFLEX AND GRAVE
        // U+1ED1: "á»‘" LATIN SMALL LETTER O WITH CIRCUMFLEX AND ACUTE
        // U+1ED5: "á»•" LATIN SMALL LETTER O WITH CIRCUMFLEX AND HOOK ABOVE
        // U+1ED7: "á»—" LATIN SMALL LETTER O WITH CIRCUMFLEX AND TILDE
        // U+1ED9: "á»™" LATIN SMALL LETTER O WITH CIRCUMFLEX AND DOT BELOW
        // U+01A1: "Æ¡" LATIN SMALL LETTER O WITH HORN
        // U+1EDD: "á»�" LATIN SMALL LETTER O WITH HORN AND GRAVE
        // U+1EDB: "á»›" LATIN SMALL LETTER O WITH HORN AND ACUTE
        // U+1EDF: "á»Ÿ" LATIN SMALL LETTER O WITH HORN AND HOOK ABOVE
        // U+1EE1: "á»¡" LATIN SMALL LETTER O WITH HORN AND TILDE
        // U+1EE3: "á»£" LATIN SMALL LETTER O WITH HORN AND DOT BELOW
        /* morekeys_o */ "\u00F2,\u00F3,\u1ECF,\u00F5,\u1ECD,\u00F4,\u1ED3,\u1ED1,\u1ED5,\u1ED7,\u1ED9,\u01A1,\u1EDD,\u1EDB,\u1EDF,\u1EE1,\u1EE3",
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+1EBB: "áº»" LATIN SMALL LETTER E WITH HOOK ABOVE
        // U+1EBD: "áº½" LATIN SMALL LETTER E WITH TILDE
        // U+1EB9: "áº¹" LATIN SMALL LETTER E WITH DOT BELOW
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+1EC1: "á»�" LATIN SMALL LETTER E WITH CIRCUMFLEX AND GRAVE
        // U+1EBF: "áº¿" LATIN SMALL LETTER E WITH CIRCUMFLEX AND ACUTE
        // U+1EC3: "á»ƒ" LATIN SMALL LETTER E WITH CIRCUMFLEX AND HOOK ABOVE
        // U+1EC5: "á»…" LATIN SMALL LETTER E WITH CIRCUMFLEX AND TILDE
        // U+1EC7: "á»‡" LATIN SMALL LETTER E WITH CIRCUMFLEX AND DOT BELOW
        /* morekeys_e */ "\u00E8,\u00E9,\u1EBB,\u1EBD,\u1EB9,\u00EA,\u1EC1,\u1EBF,\u1EC3,\u1EC5,\u1EC7",
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+1EE7: "á»§" LATIN SMALL LETTER U WITH HOOK ABOVE
        // U+0169: "Å©" LATIN SMALL LETTER U WITH TILDE
        // U+1EE5: "á»¥" LATIN SMALL LETTER U WITH DOT BELOW
        // U+01B0: "Æ°" LATIN SMALL LETTER U WITH HORN
        // U+1EEB: "á»«" LATIN SMALL LETTER U WITH HORN AND GRAVE
        // U+1EE9: "á»©" LATIN SMALL LETTER U WITH HORN AND ACUTE
        // U+1EED: "á»­" LATIN SMALL LETTER U WITH HORN AND HOOK ABOVE
        // U+1EEF: "á»¯" LATIN SMALL LETTER U WITH HORN AND TILDE
        // U+1EF1: "á»±" LATIN SMALL LETTER U WITH HORN AND DOT BELOW
        /* morekeys_u */ "\u00F9,\u00FA,\u1EE7,\u0169,\u1EE5,\u01B0,\u1EEB,\u1EE9,\u1EED,\u1EEF,\u1EF1",
        /* keylabel_to_alpha */ null,
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+1EC9: "á»‰" LATIN SMALL LETTER I WITH HOOK ABOVE
        // U+0129: "Ä©" LATIN SMALL LETTER I WITH TILDE
        // U+1ECB: "á»‹" LATIN SMALL LETTER I WITH DOT BELOW
        /* morekeys_i */ "\u00EC,\u00ED,\u1EC9,\u0129,\u1ECB",
        /* morekeys_n ~ */
        null, null, null, null, null,
        /* ~ single_quotes */
        // U+20AB: "â‚«" DONG SIGN
        /* keyspec_currency */ "\u20AB",
        // U+1EF3: "á»³" LATIN SMALL LETTER Y WITH GRAVE
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        // U+1EF7: "á»·" LATIN SMALL LETTER Y WITH HOOK ABOVE
        // U+1EF9: "á»¹" LATIN SMALL LETTER Y WITH TILDE
        // U+1EF5: "á»µ" LATIN SMALL LETTER Y WITH DOT BELOW
        /* morekeys_y */ "\u1EF3,\u00FD,\u1EF7,\u1EF9,\u1EF5",
        /* morekeys_z */ null,
        // U+0111: "Ä‘" LATIN SMALL LETTER D WITH STROKE
        /* morekeys_d */ "\u0111",
    };

    /* Locale zu: Zulu */
    private static final String[] TEXTS_zu = {
        // This is the same as English
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        /* morekeys_a */ "\u00E0,\u00E1,\u00E2,\u00E4,\u00E6,\u00E3,\u00E5,\u0101",
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        /* morekeys_o */ "\u00F3,\u00F4,\u00F6,\u00F2,\u0153,\u00F8,\u014D,\u00F5",
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        /* morekeys_e */ "\u00E9,\u00E8,\u00EA,\u00EB,\u0113",
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        /* morekeys_u */ "\u00FA,\u00FB,\u00FC,\u00F9,\u016B",
        /* keylabel_to_alpha */ null,
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        /* morekeys_i */ "\u00ED,\u00EE,\u00EF,\u012B,\u00EC",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        /* morekeys_n */ "\u00F1",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        /* morekeys_c */ "\u00E7",
        /* double_quotes */ null,
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        /* morekeys_s */ "\u00DF",
    };

    /* Locale zz: Alphabet */
    private static final String[] TEXTS_zz = {
        // U+00E0: "Ã " LATIN SMALL LETTER A WITH GRAVE
        // U+00E1: "Ã¡" LATIN SMALL LETTER A WITH ACUTE
        // U+00E2: "Ã¢" LATIN SMALL LETTER A WITH CIRCUMFLEX
        // U+00E3: "Ã£" LATIN SMALL LETTER A WITH TILDE
        // U+00E4: "Ã¤" LATIN SMALL LETTER A WITH DIAERESIS
        // U+00E5: "Ã¥" LATIN SMALL LETTER A WITH RING ABOVE
        // U+00E6: "Ã¦" LATIN SMALL LETTER AE
        // U+0101: "Ä�" LATIN SMALL LETTER A WITH MACRON
        // U+0103: "Äƒ" LATIN SMALL LETTER A WITH BREVE
        // U+0105: "Ä…" LATIN SMALL LETTER A WITH OGONEK
        // U+00AA: "Âª" FEMININE ORDINAL INDICATOR
        /* morekeys_a */ "\u00E0,\u00E1,\u00E2,\u00E3,\u00E4,\u00E5,\u00E6,\u0101,\u0103,\u0105,\u00AA",
        // U+00F2: "Ã²" LATIN SMALL LETTER O WITH GRAVE
        // U+00F3: "Ã³" LATIN SMALL LETTER O WITH ACUTE
        // U+00F4: "Ã´" LATIN SMALL LETTER O WITH CIRCUMFLEX
        // U+00F5: "Ãµ" LATIN SMALL LETTER O WITH TILDE
        // U+00F6: "Ã¶" LATIN SMALL LETTER O WITH DIAERESIS
        // U+00F8: "Ã¸" LATIN SMALL LETTER O WITH STROKE
        // U+014D: "Å�" LATIN SMALL LETTER O WITH MACRON
        // U+014F: "Å�" LATIN SMALL LETTER O WITH BREVE
        // U+0151: "Å‘" LATIN SMALL LETTER O WITH DOUBLE ACUTE
        // U+0153: "Å“" LATIN SMALL LIGATURE OE
        // U+00BA: "Âº" MASCULINE ORDINAL INDICATOR
        /* morekeys_o */ "\u00F2,\u00F3,\u00F4,\u00F5,\u00F6,\u00F8,\u014D,\u014F,\u0151,\u0153,\u00BA",
        // U+00E8: "Ã¨" LATIN SMALL LETTER E WITH GRAVE
        // U+00E9: "Ã©" LATIN SMALL LETTER E WITH ACUTE
        // U+00EA: "Ãª" LATIN SMALL LETTER E WITH CIRCUMFLEX
        // U+00EB: "Ã«" LATIN SMALL LETTER E WITH DIAERESIS
        // U+0113: "Ä“" LATIN SMALL LETTER E WITH MACRON
        // U+0115: "Ä•" LATIN SMALL LETTER E WITH BREVE
        // U+0117: "Ä—" LATIN SMALL LETTER E WITH DOT ABOVE
        // U+0119: "Ä™" LATIN SMALL LETTER E WITH OGONEK
        // U+011B: "Ä›" LATIN SMALL LETTER E WITH CARON
        /* morekeys_e */ "\u00E8,\u00E9,\u00EA,\u00EB,\u0113,\u0115,\u0117,\u0119,\u011B",
        // U+00F9: "Ã¹" LATIN SMALL LETTER U WITH GRAVE
        // U+00FA: "Ãº" LATIN SMALL LETTER U WITH ACUTE
        // U+00FB: "Ã»" LATIN SMALL LETTER U WITH CIRCUMFLEX
        // U+00FC: "Ã¼" LATIN SMALL LETTER U WITH DIAERESIS
        // U+0169: "Å©" LATIN SMALL LETTER U WITH TILDE
        // U+016B: "Å«" LATIN SMALL LETTER U WITH MACRON
        // U+016D: "Å­" LATIN SMALL LETTER U WITH BREVE
        // U+016F: "Å¯" LATIN SMALL LETTER U WITH RING ABOVE
        // U+0171: "Å±" LATIN SMALL LETTER U WITH DOUBLE ACUTE
        // U+0173: "Å³" LATIN SMALL LETTER U WITH OGONEK
        /* morekeys_u */ "\u00F9,\u00FA,\u00FB,\u00FC,\u0169,\u016B,\u016D,\u016F,\u0171,\u0173",
        /* keylabel_to_alpha */ null,
        // U+00EC: "Ã¬" LATIN SMALL LETTER I WITH GRAVE
        // U+00ED: "Ã­" LATIN SMALL LETTER I WITH ACUTE
        // U+00EE: "Ã®" LATIN SMALL LETTER I WITH CIRCUMFLEX
        // U+00EF: "Ã¯" LATIN SMALL LETTER I WITH DIAERESIS
        // U+0129: "Ä©" LATIN SMALL LETTER I WITH TILDE
        // U+012B: "Ä«" LATIN SMALL LETTER I WITH MACRON
        // U+012D: "Ä­" LATIN SMALL LETTER I WITH BREVE
        // U+012F: "Ä¯" LATIN SMALL LETTER I WITH OGONEK
        // U+0131: "Ä±" LATIN SMALL LETTER DOTLESS I
        // U+0133: "Ä³" LATIN SMALL LIGATURE IJ
        /* morekeys_i */ "\u00EC,\u00ED,\u00EE,\u00EF,\u0129,\u012B,\u012D,\u012F,\u0131,\u0133",
        // U+00F1: "Ã±" LATIN SMALL LETTER N WITH TILDE
        // U+0144: "Å„" LATIN SMALL LETTER N WITH ACUTE
        // U+0146: "Å†" LATIN SMALL LETTER N WITH CEDILLA
        // U+0148: "Åˆ" LATIN SMALL LETTER N WITH CARON
        // U+0149: "Å‰" LATIN SMALL LETTER N PRECEDED BY APOSTROPHE
        // U+014B: "Å‹" LATIN SMALL LETTER ENG
        /* morekeys_n */ "\u00F1,\u0144,\u0146,\u0148,\u0149,\u014B",
        // U+00E7: "Ã§" LATIN SMALL LETTER C WITH CEDILLA
        // U+0107: "Ä‡" LATIN SMALL LETTER C WITH ACUTE
        // U+0109: "Ä‰" LATIN SMALL LETTER C WITH CIRCUMFLEX
        // U+010B: "Ä‹" LATIN SMALL LETTER C WITH DOT ABOVE
        // U+010D: "Ä�" LATIN SMALL LETTER C WITH CARON
        /* morekeys_c */ "\u00E7,\u0107,\u0109,\u010B,\u010D",
        /* double_quotes */ null,
        // U+00DF: "ÃŸ" LATIN SMALL LETTER SHARP S
        // U+015B: "Å›" LATIN SMALL LETTER S WITH ACUTE
        // U+015D: "Å�" LATIN SMALL LETTER S WITH CIRCUMFLEX
        // U+015F: "ÅŸ" LATIN SMALL LETTER S WITH CEDILLA
        // U+0161: "Å¡" LATIN SMALL LETTER S WITH CARON
        // U+017F: "Å¿" LATIN SMALL LETTER LONG S
        /* morekeys_s */ "\u00DF,\u015B,\u015D,\u015F,\u0161,\u017F",
        /* single_quotes */ null,
        /* keyspec_currency */ null,
        // U+00FD: "Ã½" LATIN SMALL LETTER Y WITH ACUTE
        // U+0177: "Å·" LATIN SMALL LETTER Y WITH CIRCUMFLEX
        // U+00FF: "Ã¿" LATIN SMALL LETTER Y WITH DIAERESIS
        // U+0133: "Ä³" LATIN SMALL LIGATURE IJ
        /* morekeys_y */ "\u00FD,\u0177,\u00FF,\u0133",
        // U+017A: "Åº" LATIN SMALL LETTER Z WITH ACUTE
        // U+017C: "Å¼" LATIN SMALL LETTER Z WITH DOT ABOVE
        // U+017E: "Å¾" LATIN SMALL LETTER Z WITH CARON
        /* morekeys_z */ "\u017A,\u017C,\u017E",
        // U+010F: "Ä�" LATIN SMALL LETTER D WITH CARON
        // U+0111: "Ä‘" LATIN SMALL LETTER D WITH STROKE
        // U+00F0: "Ã°" LATIN SMALL LETTER ETH
        /* morekeys_d */ "\u010F,\u0111,\u00F0",
        // U+00FE: "Ã¾" LATIN SMALL LETTER THORN
        // U+0163: "Å£" LATIN SMALL LETTER T WITH CEDILLA
        // U+0165: "Å¥" LATIN SMALL LETTER T WITH CARON
        // U+0167: "Å§" LATIN SMALL LETTER T WITH STROKE
        /* morekeys_t */ "\u00FE,\u0163,\u0165,\u0167",
        // U+013A: "Äº" LATIN SMALL LETTER L WITH ACUTE
        // U+013C: "Ä¼" LATIN SMALL LETTER L WITH CEDILLA
        // U+013E: "Ä¾" LATIN SMALL LETTER L WITH CARON
        // U+0140: "Å€" LATIN SMALL LETTER L WITH MIDDLE DOT
        // U+0142: "Å‚" LATIN SMALL LETTER L WITH STROKE
        /* morekeys_l */ "\u013A,\u013C,\u013E,\u0140,\u0142",
        // U+011D: "Ä�" LATIN SMALL LETTER G WITH CIRCUMFLEX
        // U+011F: "ÄŸ" LATIN SMALL LETTER G WITH BREVE
        // U+0121: "Ä¡" LATIN SMALL LETTER G WITH DOT ABOVE
        // U+0123: "Ä£" LATIN SMALL LETTER G WITH CEDILLA
        /* morekeys_g */ "\u011D,\u011F,\u0121,\u0123",
        /* single_angle_quotes */ null,
        /* double_angle_quotes */ null,
        // U+0155: "Å•" LATIN SMALL LETTER R WITH ACUTE
        // U+0157: "Å—" LATIN SMALL LETTER R WITH CEDILLA
        // U+0159: "Å™" LATIN SMALL LETTER R WITH CARON
        /* morekeys_r */ "\u0155,\u0157,\u0159",
        // U+0137: "Ä·" LATIN SMALL LETTER K WITH CEDILLA
        // U+0138: "Ä¸" LATIN SMALL LETTER KRA
        /* morekeys_k */ "\u0137,\u0138",
        /* morekeys_cyrillic_ie ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null,
        /* ~ morekeys_question */
        // U+0125: "Ä¥" LATIN SMALL LETTER H WITH CIRCUMFLEX
        /* morekeys_h */ "\u0125",
        // U+0175: "Åµ" LATIN SMALL LETTER W WITH CIRCUMFLEX
        /* morekeys_w */ "\u0175",
        /* morekeys_east_slavic_row2_2 ~ */
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
        null, null,
        /* ~ morekeys_v */
        // U+0135: "Äµ" LATIN SMALL LETTER J WITH CIRCUMFLEX
        /* morekeys_j */ "\u0135",
    };

    private static final Object[] LOCALES_AND_TEXTS = {
    // "locale", TEXT_ARRAY,  /* numberOfNonNullText/lengthOf_TEXT_ARRAY localeName */
        "DEFAULT", TEXTS_DEFAULT, /* 176/176 DEFAULT */
        "af"     , TEXTS_af,    /*   7/ 13 Afrikaans */
        "ar"     , TEXTS_ar,    /*  55/110 Arabic */
        "ar_AE"  , TEXTS_ar_AE, /*  55/110 Arabic (UAE) */
        "ar_QA"  , TEXTS_ar_QA, /*  55/110 Arabic (Qatar) */
        "az_AZ"  , TEXTS_az_AZ, /*  11/ 18 Azerbaijani (Azerbaijan) */
        "be_BY"  , TEXTS_be_BY, /*   9/ 32 Belarusian (Belarus) */
        "bg"     , TEXTS_bg,    /*   2/  9 Bulgarian */
        "bn_BD"  , TEXTS_bn_BD, /*   2/ 12 Bengali (Bangladesh) */
        "bn_IN"  , TEXTS_bn_IN, /*   2/ 12 Bengali (India) */
        "ca"     , TEXTS_ca,    /*  11/ 99 Catalan */
        "cs"     , TEXTS_cs,    /*  17/ 21 Czech */
        "da"     , TEXTS_da,    /*  19/ 55 Danish */
        "de"     , TEXTS_de,    /*  16/ 66 German */
        "el"     , TEXTS_el,    /*   1/  5 Greek */
        "en"     , TEXTS_en,    /*   8/ 10 English */
        "eo"     , TEXTS_eo,    /*  26/126 Esperanto */
        "es"     , TEXTS_es,    /*   8/ 56 Spanish */
        "et_EE"  , TEXTS_et_EE, /*  22/ 27 Estonian (Estonia) */
        "eu_ES"  , TEXTS_eu_ES, /*   7/  8 Basque (Spain) */
        "fa"     , TEXTS_fa,    /*  58/133 Persian */
        "fi"     , TEXTS_fi,    /*  10/ 55 Finnish */
        "fr"     , TEXTS_fr,    /*  13/ 66 French */
        "gl_ES"  , TEXTS_gl_ES, /*   7/  8 Gallegan (Spain) */
        "hi"     , TEXTS_hi,    /*  27/ 60 Hindi */
        "hi_ZZ"  , TEXTS_hi_ZZ, /*   9/118 Hindi (ZZ) */
        "hr"     , TEXTS_hr,    /*   9/ 20 Croatian */
        "hu"     , TEXTS_hu,    /*   9/ 20 Hungarian */
        "hy_AM"  , TEXTS_hy_AM, /*   9/134 Armenian (Armenia) */
        "is"     , TEXTS_is,    /*  10/ 16 Icelandic */
        "it"     , TEXTS_it,    /*  11/ 66 Italian */
        "iw"     , TEXTS_iw,    /*  20/131 Hebrew */
        "ka_GE"  , TEXTS_ka_GE, /*   3/ 11 Georgian (Georgia) */
        "kk"     , TEXTS_kk,    /*  15/129 Kazakh */
        "km_KH"  , TEXTS_km_KH, /*   2/130 Khmer (Cambodia) */
        "kn_IN"  , TEXTS_kn_IN, /*   2/ 12 Kannada (India) */
        "ky"     , TEXTS_ky,    /*  10/ 92 Kirghiz */
        "lo_LA"  , TEXTS_lo_LA, /*   2/ 12 Lao (Laos) */
        "lt"     , TEXTS_lt,    /*  18/ 22 Lithuanian */
        "lv"     , TEXTS_lv,    /*  18/ 22 Latvian */
        "mk"     , TEXTS_mk,    /*   9/ 97 Macedonian */
        "ml_IN"  , TEXTS_ml_IN, /*   2/ 12 Malayalam (India) */
        "mn_MN"  , TEXTS_mn_MN, /*   2/ 12 Mongolian (Mongolia) */
        "mr_IN"  , TEXTS_mr_IN, /*  23/ 53 Marathi (India) */
        "nb"     , TEXTS_nb,    /*  11/ 55 Norwegian BokmÃ¥l */
        "ne_NP"  , TEXTS_ne_NP, /*  27/ 60 Nepali (Nepal) */
        "nl"     , TEXTS_nl,    /*   9/ 13 Dutch */
        "pl"     , TEXTS_pl,    /*  10/ 17 Polish */
        "pt"     , TEXTS_pt,    /*   6/  8 Portuguese */
        "rm"     , TEXTS_rm,    /*   1/  2 Raeto-Romance */
        "ro"     , TEXTS_ro,    /*   6/ 16 Romanian */
        "ru"     , TEXTS_ru,    /*   9/ 32 Russian */
        "si_LK"  , TEXTS_si_LK, /*   2/ 12 Sinhalese (Sri Lanka) */
        "sk"     , TEXTS_sk,    /*  20/ 22 Slovak */
        "sl"     , TEXTS_sl,    /*   8/ 20 Slovenian */
        "sr"     , TEXTS_sr,    /*  11/ 97 Serbian */
        "sr_ZZ"  , TEXTS_sr_ZZ, /*  14/118 Serbian (ZZ) */
        "sv"     , TEXTS_sv,    /*  21/ 55 Swedish */
        "sw"     , TEXTS_sw,    /*   9/ 18 Swahili */
        "ta_IN"  , TEXTS_ta_IN, /*   2/ 12 Tamil (India) */
        "ta_LK"  , TEXTS_ta_LK, /*   2/ 12 Tamil (Sri Lanka) */
        "ta_SG"  , TEXTS_ta_SG, /*   1/  5 Tamil (Singapore) */
        "te_IN"  , TEXTS_te_IN, /*   2/ 12 Telugu (India) */
        "th"     , TEXTS_th,    /*   2/ 12 Thai */
        "tl"     , TEXTS_tl,    /*   7/  8 Tagalog */
        "tr"     , TEXTS_tr,    /*  11/ 18 Turkish */
        "uk"     , TEXTS_uk,    /*  11/ 91 Ukrainian */
        "uz_UZ"  , TEXTS_uz_UZ, /*  11/ 18 Uzbek (Uzbekistan) */
        "vi"     , TEXTS_vi,    /*   8/ 15 Vietnamese */
        "zu"     , TEXTS_zu,    /*   8/ 10 Zulu */
        "zz"     , TEXTS_zz,    /*  19/120 Alphabet */
    };

    static {
        for (int index = 0; index < NAMES.length; index++) {
            sNameToIndexesMap.put(NAMES[index], index);
        }

        for (int i = 0; i < LOCALES_AND_TEXTS.length; i += 2) {
            final String locale = (String)LOCALES_AND_TEXTS[i];
            final String[] textsTable = (String[])LOCALES_AND_TEXTS[i + 1];
            sLocaleToTextsTableMap.put(locale, textsTable);
            sTextsTableToLocaleMap.put(textsTable, locale);
        }
    }
}
