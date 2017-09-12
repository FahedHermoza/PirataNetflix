package com.devart.fahed.developer.pruebastreaming01;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetalleVideoActivityFragment extends Fragment {

    private View rootView;

    private Spinner spTemporadas;
    private final static  String [] TEMPORADAS = {"Temporada 1","Temporada 2","Temporada 3",
            "Temporada 4","Temporada 5","Temporada 6", "Temporada 7", "Temporada 8"};

    private RecyclerView mTemporadasRecyclerView;
    private TemporadaAdapter mAdapter;

    public DetalleVideoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detalle_video, container, false);

        spTemporadas = (Spinner) rootView.findViewById(R.id.spTemporadasDetalleVideo);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_temporadas, TEMPORADAS);
        spTemporadas.setAdapter(adapter);

        spTemporadas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio

            }
        });

        mTemporadasRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvDetalleTemporadas);
        mTemporadasRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        updateUI();


        return rootView;
    }

    private void updateUI(){

        List<Temporada> temporadas= new ArrayList<>() ;
        for (int i=0;i<10;i++){
            Temporada temporada = new Temporada();
            temporada.setCapitulo(""+(i+1));
            temporada.setTitulo("Titulo "+ (i+1));
            temporada.setDuracion((100+i) + " min");
            temporadas.add(temporada);
        }

        if (mAdapter == null) {
            mAdapter = new TemporadaAdapter(temporadas);
            mTemporadasRecyclerView.setAdapter(mAdapter);
        }else{
            //Actualizamos solo el item que cambio en el recycler View

            //mAdapter.notifyItemChanged(mItemUpdatePosition);
            //mItemUpdatePosition = RecyclerView.NO_POSITION;
        }

    }

    private class TemporadaHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Temporada mTemporada;


        private TextView mCapituloTextView;
        private TextView mTituloTextView;
        private TextView mDuracionTextView;
        private ImageButton mReproducirImageButton;

        public TemporadaHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mCapituloTextView = (TextView) itemView.findViewById(R.id.tvCapituloItemTemporada);
            mTituloTextView = (TextView) itemView.findViewById(R.id.tvTituloItemTemporada);
            mDuracionTextView = (TextView) itemView.findViewById(R.id.tvDuracionItemTemporada);
            mReproducirImageButton= (ImageButton) itemView.findViewById(R.id.ivReproducirItemTemporada);
        }

        public void bindVideo(Temporada temporada){
            mTemporada = temporada;
            mCapituloTextView.setText(mTemporada.getCapitulo());
            mTituloTextView.setText(mTemporada.getTitulo());
            mDuracionTextView.setText(mTemporada.getDuracion());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mTemporada.getTitulo() +" clicekd!", Toast.LENGTH_SHORT).show();
        }
    }

    private class TemporadaAdapter extends RecyclerView.Adapter<DetalleVideoActivityFragment.TemporadaHolder>{

        private List<Temporada> mTemporadas;

        public TemporadaAdapter(List<Temporada> temporadas){
            mTemporadas = temporadas;
        }

        @Override
        public DetalleVideoActivityFragment.TemporadaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.lista_item_temporada,parent, false);
            return  new DetalleVideoActivityFragment.TemporadaHolder(view);
        }

        @Override
        public void onBindViewHolder(DetalleVideoActivityFragment.TemporadaHolder holder, int position) {
            Temporada temporada = mTemporadas.get(position);
            //Enlazar widgets
            holder.bindVideo(temporada);
        }

        @Override
        public int getItemCount() {
            return mTemporadas.size();
        }

    }

}
