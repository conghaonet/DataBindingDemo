# DataBindingDemo

### 基础配置

然后修改对应模块（Module）的 build.gradle：
```groovy
android {
    ......
    dataBinding {
        enabled = true
    }
    ......
}
```
启用dataBinding后，工程会自动添加如下依赖包：
* com.android.databinding:library:{Version}
* com.android.databinding:adapters:{Version}
* com.android.databinding:compiler:{Version}
* com.android.databinding:compilerCommon:{Version}
* com.android.databinding:baseLibrary:{Version}

strings.xml：
```xml
<resources>
    <string name="app_name">ModuleA</string>
    <string name="age">岁</string>
</resources>
```

activity_module_a.xml：
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <variable name="user" type="com.app2m.modulea.bean.User"/>
    </data>
    <LinearLayout
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <TextView android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:text='@{"姓名：" + user.name, default=YourName}'/>
        <TextView android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:text='@{"年龄：" + user.age + @string/age}'/>
        <TextView android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:text='@{user.isMarried ? "婚否：已婚" : "婚否：未婚"}'/>
    </LinearLayout>
</layout>
```

ModuleAActivity.java：
```java
public class ModuleAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityModuleABinding binding = DataBindingUtil.setContentView(this, R.layout.activity_module_a);
        User user =new User();
        user.setName("张三");
        user.setAge(28);
        user.setMarried(true);
        binding.setUser(user);
    }
}

```