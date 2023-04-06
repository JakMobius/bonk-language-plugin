package com.jakmobius.bonk.style;

import com.intellij.application.options.IndentOptionsEditor;
import com.intellij.application.options.SmartIndentOptionsEditor;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import com.jakmobius.bonk.BonkFileType;
import com.jakmobius.bonk.BonkLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BonkLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {
    @Override
    public @Nullable String getCodeSample(@NotNull SettingsType settingsType) {
        return "hive LinkedList {\n" +
                "  bowl start: LinkedListItem = null;\n" +
                "  bowl end: LinkedListItem = null;\n" +
                "}\n" +
                "\n" +
                "blok linked_list_add[bowl list: LinkedList, bowl element: nubr] {\n" +
                "  (start of list != null) or {\n" +
                "    start of list = @LinkedListItem[item = element];\n" +
                "    end of list = start of list;\n" +
                "    bonk;\n" +
                "  };\n" +
                "\n" +
                "  bowl end = end of list;\n" +
                "  next of end = @LinkedListItem[item = element];\n" +
                "  end of list = next of end;\n" +
                "}";
    }

    @NotNull
    @Override
    public Language getLanguage() {
        return BonkLanguage.INSTANCE;
    }

    @Nullable
    @Override
    public IndentOptionsEditor getIndentOptionsEditor() {
        return new SmartIndentOptionsEditor();
    }

    @Override
    public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
        if (settingsType == SettingsType.INDENT_SETTINGS) {
            consumer.showStandardOptions("TAB_SIZE", "INDENT_SIZE", "CONTINUATION_INDENT_SIZE", "USE_TAB_CHARACTER");
            consumer.showCustomOption(BonkCodeStyleSettings.class, "SPECIAL_INDENT", "Special indent", null);
        }
    }
}