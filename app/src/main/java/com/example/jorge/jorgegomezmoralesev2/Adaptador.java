package com.example.jorge.jorgegomezmoralesev2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jorge on 21/02/18.
 */

public class Adaptador extends BaseAdapter {

    Context contexto; //contexto de la aplicacion
    List<Pais> items; //lista de datos a generar. Podemos usar tb un ArrayList

    public Adaptador(Context contexto, List<Pais> items) {
        this.contexto = contexto;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista=view;
        LayoutInflater inflate = LayoutInflater.from(contexto); //Obtenemos el contexto del item sobre el cual estamos trabajando del ListView
        vista=inflate.inflate(R.layout.item, null); //Consigo referenciar a la vista en sí

        TextView tvNombreIngles = (TextView)vista.findViewById(R.id.tvNombreIngles);
        TextView tvNombreCastellano = (TextView)vista.findViewById(R.id.tvNombreCastellano);
        TextView tvClave = (TextView)vista.findViewById(R.id.tvClave);
        TextView tvCapital = (TextView)vista.findViewById(R.id.tvCapital);
        TextView tvContinente = (TextView)vista.findViewById(R.id.tvContinente);
        TextView tvPoblacion = (TextView)vista.findViewById(R.id.tvPoblacion);
        TextView tvLatitud = (TextView)vista.findViewById(R.id.tvLatitud);
        TextView tvLongitud = (TextView)vista.findViewById(R.id.tvLongitud);
        TextView tvFronteras = (TextView)vista.findViewById(R.id.tvPaisesFronterizos);

        tvNombreIngles.setText(items.get(i).getNombreIngles());
        tvNombreCastellano.setText(items.get(i).getNombreCastellano());
        tvClave.setText(tvClave.getText().toString() + items.get(i).getCod2Letras());
        tvCapital.setText(tvCapital.getText().toString() + items.get(i).getCapital());
        tvContinente.setText(tvContinente.getText().toString() + items.get(i).getContinente());
        tvPoblacion.setText(tvPoblacion.getText().toString() + items.get(i).getPoblacion());
        tvLatitud.setText(tvLatitud.getText().toString() + items.get(i).getLatitud());
        tvLongitud.setText(tvLongitud.getText().toString() + items.get(i).getLongitud());
        tvFronteras.setText("");
        if (items.get(i).getPaisesFronterizos().size() == 0) {
            tvFronteras.setText("No linda con nadie");
        }
        else {
            for (int j = 0; j < items.get(i).getPaisesFronterizos().size(); j++) {
                tvFronteras.setText(tvFronteras.getText().toString() + " " + items.get(i).getPaisesFronterizos().get(j));
            }
        }
        return vista;
    }


}
