/*
 * Copyright (C) 2012 The Android Open Source Project
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

import com.phonemetra.turbo.keyboard.latin.define.JniLibName;

public final class JniUtils {
	
	private static final String TAG = "JniUtils";
	public static boolean mHaveGestureLib = false;

	private JniUtils() {

	}

	public static void loadNativeLibrary() {

		try {
			System.loadLibrary(JniLibName.JNI_LIB_NAME2);
			mHaveGestureLib = true;
		} catch (UnsatisfiedLinkError ue) {
			try {
				System.loadLibrary(JniLibName.JNI_LIB_NAME);
			 } catch (UnsatisfiedLinkError e) {
				Log.e(TAG, "Could not load native library "
						+ JniLibName.JNI_LIB_NAME, e);
			}
		}
	}
}
