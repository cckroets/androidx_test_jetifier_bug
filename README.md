# androidx_test_jetifier_bug

Demo bug with AndroidX test library when enabling accessibility and Jetifier is not enabled


To repro:

- Create new project with AndroidX enabled
- Add dependencies:
```
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0-alpha03'
    androidTestImplementation 'androidx.test.espresso:espresso-contrib:3.3.0-alpha03'
    androidTestImplementation 'androidx.test.espresso:espresso-accessibility:3.3.0-alpha03'
```
- Set `android.enableJetifier=false` in `gradle.properties`
- Add `AccessibilityChecks.enable();` to an instrumentation test
- Run test, observe crash:

```
java.lang.NoClassDefFoundError: Failed resolution of: Landroid/support/v4/view/ViewPager;
at com.google.android.apps.common.testing.accessibility.framework.SpeakableTextPresentViewCheck.<clinit>(SpeakableTextPresentViewCheck.java:42)
at com.google.android.apps.common.testing.accessibility.framework.AccessibilityCheckPreset.getViewChecksForPreset(AccessibilityCheckPreset.java:59)
at com.google.android.apps.common.testing.accessibility.framework.integrations.espresso.AccessibilityValidator.<init>(AccessibilityValidator.java:50)
at androidx.test.espresso.accessibility.AccessibilityChecks.<clinit>(AccessibilityChecks.java:37)
at androidx.test.espresso.accessibility.AccessibilityChecks.enable(AccessibilityChecks.java:84)
```

This is due to this library not being updated to AndroidX:
https://github.com/google/Accessibility-Test-Framework-for-Android/

despite the fact that is depended on by the AndroidX Test library.  
