package meme2lz.wumf;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;

public class MainActivityFragment extends ListFragment {

    private ArrayList<AlarmModel> arrayList;
    private AlarmAdapter alarmAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //Adding the values of the notes from the DBHelper
        DatabaseHelper dbHelper = new DatabaseHelper(getActivity().getBaseContext());
        dbHelper.open();
        arrayList = dbHelper.getAll();
        dbHelper.close();
        alarmAdapter = new AlarmAdapter(getActivity(), arrayList);
        setListAdapter(alarmAdapter);

        //Displaying the menu if the user long click the item in the listview
        registerForContextMenu(getListView());
    }

//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//        launchNoteDetailActivity(MainActivity.FRAGMENT_TO_LOAD.VIEW, position);
//    }

    //Displaying the menu if the user long clicks the item in the listview
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//
//        //Setting the name of the menu
//        MenuInflater menuInflater = getActivity().getMenuInflater();
//        menuInflater.inflate(R.menu.long_press_menu,menu);
//    }





}