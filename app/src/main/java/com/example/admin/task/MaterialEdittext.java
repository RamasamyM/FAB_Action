package com.example.admin.task;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Admin on 1/5/2016.
 */
public class MaterialEdittext extends Fragment {


    private static final String TAG= MaterialEdittext.class.getSimpleName();



    private static  String autoSave;
    private TextInputLayout  textInputLayout;
    private EditText editText;
    private Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"entered oncreate method ");
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.material_edittext,null,false);
        textInputLayout= (TextInputLayout) view.findViewById(R.id.input_layout_name);
        editText= (EditText) view.findViewById(R.id.input_name);
        editText.addTextChangedListener(new MyTextFollow(editText));
        button= (Button)view.findViewById(R.id.iuput_button) ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkMyEditText())
                {
                    Log.d(TAG,"check  edit text");
                    return;
                }
                Toast.makeText(getActivity(),"material edit  text",Toast.LENGTH_SHORT).show();
            }
        });

     /*   final  SharedPreferences  sharedPreferences= this.getActivity().getSharedPreferences("PREFS",0);
        editText.setText(sharedPreferences.getString(autoSave, null));*/
        return  view;
    }


    private boolean checkMyEditText()
    {
        if(editText.getText().toString().trim().isEmpty() )
        {
            Log.d(TAG,"check  my edit text method ");
            textInputLayout.setError("enter the  text");
                  requestFocus(editText);
            return false;
        }

            else{
            textInputLayout.setErrorEnabled(false);

        }
        return true;
    }
    private void requestFocus(View view)
    {
        if(view.requestFocus())
        {
            Log.d(TAG,"request  focus");
            getWindow().setSoftInputMode
                    (WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

    }

    private Window getWindow()
    {
        Log.d(TAG,"get windwo method entered ");
        return getWindow();
    }


    private class MyTextFollow implements TextWatcher
    {

        private View view;
        public MyTextFollow(View view)
        {
            Log.d(TAG,"mt text follow constructor ");
            this.view= view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Log.d(TAG," beforeTextChanged method entered ");

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.d(TAG," onTextChanged method entered ");
        }

        @Override
        public void afterTextChanged(Editable s) {

            Log.d(TAG," after text change entered ");
         switch(getView().getId())
            {

                case R.id.input_name:
                    checkMyEditText();
                    break;

               /* default:
                    break;*/
            }
        }
    }




}
