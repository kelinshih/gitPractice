package com.example.jayfu.myapplication;

import android.content.Context;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;






/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    final UiDevice uiDevice=UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    final String TAG ="Jay";

    @Before
    public void setUp() throws IOException
    {
        uiDevice.executeShellCommand( "am start -n com.kddi.android.UtaPass/.HomeActivity");
        uiDevice.wait(Until.hasObject(  By.res("com.kddi.android.UtaPass:id/notice_read_more")),10*1000);

    }

    @After
    public  void tearDown() throws InterruptedException,IOException
    {
        Thread.sleep(5*1000);
        uiDevice.executeShellCommand("am force-stop com.kddi.android.UtaPass");
        Log.i(TAG, "Test Complete");
    }

    @Test
    //Player - Nowplaying Page
    public void TestCase_1() throws RemoteException, InterruptedException, UiObjectNotFoundException {

        UiScrollable uiScrollable = new UiScrollable(new UiSelector().scrollable(true));
        uiScrollable.scrollTextIntoView("Artist new release");
        uiDevice.findObject(new UiSelector().resourceId("com.kddi.android.UtaPass:id/view_playlist_play_icon").instance(1)).clickAndWaitForNewWindow();

        /*uiDevice.findObject(new UiSelector().text("設定")).clickAndWaitForNewWindow();
        UiScrollable uiScrollable=new UiScrollable(new UiSelector().scrollable(true));
        uiScrollable.scrollTextIntoView("プランを変更");
        uiDevice.findObject(new UiSelector().text("プランを変更")).clickAndWaitForNewWindow();*/


    }

}
