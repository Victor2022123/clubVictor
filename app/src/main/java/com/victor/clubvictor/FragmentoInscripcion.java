package com.victor.clubvictor;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FragmentoInscripcion extends Fragment {

    Button botonRegistroGuardar;
    EditText nombreEditText,telefonoEditText, ciEditText;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        //super.onCreate(saveInstanceState);
        // setContentView(R.layout.fragment_registro);

        view = inflater.inflate(R.layout.fragmento_inscripcion, container, false);

        nombreEditText = (EditText) view.findViewById(R.id.txtNombre);

        telefonoEditText = (EditText) view.findViewById(R.id.txtTelefono);
        ciEditText = (EditText) view.findViewById(R.id.txtCi);
        botonRegistroGuardar = (Button) view.findViewById(R.id.btnGuardar);

        botonRegistroGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nombreEditText.getText().toString();

                String telefono = telefonoEditText.getText().toString();
                String  ci = ciEditText.getText().toString();
                //if(name.isEmpty() || carrera.isEmpty()){
                //    Mensaje.aviso(this, "Ingrese tatnto el nombre como la contraseña");
                //}else{

                //String url = "http://10.0.2.2:8098/api/saveUser"; // url local
               String url = "https://my-alumno-victor.onrender.com/api/saveStudent";
               // String url = "https://my-club-victor.onrender.com/api/getMembers";
                //String url = "https://my-club-victor.onrender.com/api/saveMember";
                //String url = "https://my-usuario-acme.onrender.com/api/saveUser"; // Reemplazar por la url desplegada en Render

                if(name.isEmpty()||  telefono.isEmpty()|| ci.isEmpty() ){

                    Toast.makeText(getActivity(), " Ningunos de los datos pueden quedar vacio. Falta ingresar unos de los campos ", Toast.LENGTH_SHORT).show();
                }else{

                    RequestQueue queue = Volley.newRequestQueue(getActivity());


                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response)

                        {
                            Toast.makeText(getActivity(), "Datos guardados exitosamente", Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getActivity(), "Error VC al guardar los datos " + error, Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("name", name);
                            params.put("phone", telefono);
                            params.put("document", ci);
                            return params;
                        }

                        @Override
                        public byte[] getBody() {
                            return new JSONObject(getParams()).toString().getBytes();
                        }

                        @Override
                        public String getBodyContentType() {
                            return "application/json; charset=utf-8";
                        }
                    };
                    queue.add(request);

                }


            }
        });
        return view;

    }
}
