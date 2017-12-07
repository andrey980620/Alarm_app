//package meme2lz.wumf;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.app.Activity;
//import android.content.Context;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Toast;
//import android.support.v4.app.NavUtils;
//public class ActivityHandler extends Activity {
//
//    private AlarmManagement alarm;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        alarm = new AlarmManagement();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//    }
//
//    public void startRepeatingTimer(View view) {
//        Context context = this.getApplicationContext();
//        if (alarm != null) {
//            alarm.SetAlarm(context);
//        } else {
//            Toast.makeText(context, "Alarm is null", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void cancelRepeatingTimer(View view) {
//        Context context = this.getApplicationContext();
//        if (alarm != null) {
//            alarm.CancelAlarm(context);
//        } else {
//            Toast.makeText(context, "Alarm is null", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void onetimeTimer(View view) {
//        Context context = this.getApplicationContext();
//        if (alarm != null) {
//            alarm.setOnetimeTimer(context);
//        } else {
//            Toast.makeText(context, "Alarm is null", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(menu.activity_widget_alarm_manager, menu);
//        return true;
//    }
//}
//
