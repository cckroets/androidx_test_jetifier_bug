package com.github.cckroets.androidx.test.bug;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.accessibility.AccessibilityChecks;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Before
    public void setup() {
        AccessibilityChecks.enable();
    }

    /**
     * Test fails with:
     *
     * java.lang.NoClassDefFoundError: Failed resolution of: Landroid/support/v4/view/ViewPager;
     * at com.google.android.apps.common.testing.accessibility.framework.SpeakableTextPresentViewCheck.<clinit>(SpeakableTextPresentViewCheck.java:42)
     * at com.google.android.apps.common.testing.accessibility.framework.AccessibilityCheckPreset.getViewChecksForPreset(AccessibilityCheckPreset.java:59)
     * at com.google.android.apps.common.testing.accessibility.framework.integrations.espresso.AccessibilityValidator.<init>(AccessibilityValidator.java:50)
     * at androidx.test.espresso.accessibility.AccessibilityChecks.<clinit>(AccessibilityChecks.java:37)
     * at androidx.test.espresso.accessibility.AccessibilityChecks.enable(AccessibilityChecks.java:84)
     * at com.github.cckroets.androidx.test.bug.ExampleInstrumentedTest.setup(ExampleInstrumentedTest.java:27)
     * at java.lang.reflect.Method.invoke(Native Method)
     * at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
     * at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
     * at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
     * at androidx.test.internal.runner.junit4.statement.RunBefores.evaluate(RunBefores.java:76)
     * at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
     * at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
     * at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
     * at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
     * at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
     * at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
     * at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
     * at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
     * at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
     * at androidx.test.ext.junit.runners.AndroidJUnit4.run(AndroidJUnit4.java:104)
     * at org.junit.runners.Suite.runChild(Suite.java:128)
     * at org.junit.runners.Suite.runChild(Suite.java:27)
     * at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
     * at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
     * at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
     * at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
     * at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
     * at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
     * at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
     * at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
     * at androidx.test.internal.runner.TestExecutor.execute(TestExecutor.java:56)
     * at androidx.test.runner.AndroidJUnitRunner.onStart(AndroidJUnitRunner.java:395)
     * at android.app.Instrumentation$InstrumentationThread.run(Instrumentation.java:2145)
     * Caused by: java.lang.ClassNotFoundException: Didn't find class "android.support.v4.view.ViewPager" on path: DexPathList[[zip file "/system/framework/android.test.runner.jar", zip file "/system/framework/android.test.mock.jar", zip file "/data/app/com.github.cckroets.androidx.test.bug.test-MXakWXM2i-n7bvTVhOZkhg==/base.apk", zip file "/data/app/com.github.cckroets.androidx.test.bug-NgvRvBnEvRgZLckUz7Mgpw==/base.apk"],nativeLibraryDirectories=[/data/app/com.github.cckroets.androidx.test.bug.test-MXakWXM2i-n7bvTVhOZkhg==/lib/x86, /data/app/com.github.cckroets.androidx.test.bug-NgvRvBnEvRgZLckUz7Mgpw==/lib/x86, /system/lib]]
     * at dalvik.system.BaseDexClassLoader.findClass(BaseDexClassLoader.java:134)
     * at java.lang.ClassLoader.loadClass(ClassLoader.java:379)
     * at java.lang.ClassLoader.loadClass(ClassLoader.java:312)
     * ... 34 more
     */
    @Test
    public void useAppContext() {
        ActivityScenario.launch(MainActivity.class).moveToState(Lifecycle.State.RESUMED);
        onView(withId(R.id.fab))
            .check(matches(isDisplayed()));
    }
}
