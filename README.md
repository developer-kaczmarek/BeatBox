# BeatBox - drum pad на минималках
Данное приложение является упражнением из книги Android программирование для профессионалов (3 издание). Однако исходный код не полностью соответствует коду из книги. Была добавлена маленькая функция выключения всех воспроизводимых звуков. На кнопках располагаются названия звуков, по нажатию на которые звук воспроизводится. 

Часть XML разметки:
```<android.widget.Button
        android:layout_width="match_parent"
        android:layout_height="118dp"
        android:layout_margin="1dp"
        android:background="@color/colorBackgroundButton"
        android:onClick="@{()->viewModel.onButtonClick()}"
        android:text="@{viewModel.title}"
        android:textColor="@color/colorText"
        tools:text="Sound name" />
```
Максимальное количество воспроизводимых звуков равно 5.
