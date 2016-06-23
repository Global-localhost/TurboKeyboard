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

package com.phonemetra.turbo.keyboard.compat;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

import java.lang.reflect.Method;

public final class TextViewCompatUtils {
  
    private static final Method METHOD_setCompoundDrawablesRelativeWithIntrinsicBounds =
            CompatUtils.getMethod(TextView.class, "setCompoundDrawablesRelativeWithIntrinsicBounds",
            Drawable.class, Drawable.class, Drawable.class, Drawable.class);

    private TextViewCompatUtils() {
        
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(final TextView textView,
            final Drawable start, final Drawable top, final Drawable end, final Drawable bottom) {
        if (METHOD_setCompoundDrawablesRelativeWithIntrinsicBounds == null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(start, top, end, bottom);
            return;
        }
        CompatUtils.invoke(textView, null, METHOD_setCompoundDrawablesRelativeWithIntrinsicBounds,
                start, top, end, bottom);
    }
}
