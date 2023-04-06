
package com.jakmobius.bonk;

import com.intellij.lang.Language;

public class BonkLanguage extends Language {

    public static final BonkLanguage INSTANCE = new BonkLanguage();

    private BonkLanguage() {
        super("Bonk");
    }

}