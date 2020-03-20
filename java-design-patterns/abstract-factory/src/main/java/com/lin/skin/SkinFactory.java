package com.lin.skin;

import com.lin.skin.Button;
import com.lin.skin.ComboBox;
import com.lin.skin.TextField;

public interface SkinFactory {
    Button createButton();

    TextField createTextField();

    ComboBox createComboBox();
}
