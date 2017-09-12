package com.devart.fahed.developer.pruebastreaming01;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class CategoriasActivityFragment extends Fragment {

    private View rootView;
    private RecyclerView mCategoriaRecyclerView;
    private CategoriaAdapter mAdapter;

    private final static int COLUMNAS_RECYCLER_VIEW = 2;
    private final String [] CATEGORIAS = {"Acción", "Comedias", "Romance", "Terror", "Dramas", "Series de TV"};

    public CategoriasActivityFragment() {
    }

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_categorias, container, false);

        mCategoriaRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvExplorarCategorias);
        mCategoriaRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), COLUMNAS_RECYCLER_VIEW));

        updateUI();
        return rootView;
    }

    private void updateUI(){

        List<Categoria> categorias= new ArrayList<>() ;
        for (int i=0;i<6;i++){
            Categoria categoria = new Categoria();
            categoria.setPortada("Portada");
            categoria.setTitulo( CATEGORIAS[i]);
            categorias.add(categoria);
        }

        if (mAdapter == null) {
            mAdapter = new CategoriaAdapter(categorias);
            mCategoriaRecyclerView.setAdapter(mAdapter);
        }else{
            //Actualizamos solo el item que cambio en el recycler View

            //mAdapter.notifyItemChanged(mItemUpdatePosition);
            //mItemUpdatePosition = RecyclerView.NO_POSITION;
        }

    }

    private class CategoriaHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Categoria mCategoria;

        private TextView mTituloTextView;
        private ImageView mIconoImageView;
        private ImageView mPortadaImageView;

        public CategoriaHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTituloTextView = (TextView) itemView.findViewById(R.id.tvTituloItemCategoria);
            mIconoImageView = (ImageView) itemView.findViewById(R.id.ivIconoItemCategoria);
            mPortadaImageView = (ImageView) itemView.findViewById(R.id.ivPortadaItemCategoria);
        }

        public void bindVideo(Categoria categoria){
            mCategoria = categoria;
            mTituloTextView.setText(mCategoria.getTitulo());
            mPortadaImageView.setImageDrawable(getResources().getDrawable(R.mipmap.ejemplo_portada_categoria));
            mIconoImageView.setImageDrawable(getResources().getDrawable(R.mipmap.terror_categoria));
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mCategoria.getTitulo() +" clicekd!", Toast.LENGTH_SHORT).show();
        }
    }

    private class CategoriaAdapter extends RecyclerView.Adapter<CategoriasActivityFragment.CategoriaHolder>{

        private List<Categoria> mCategorias;

        public CategoriaAdapter(List<Categoria> categorias){
            mCategorias = categorias;
        }

        @Override
        public CategoriasActivityFragment.CategoriaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.lista_item_categoria,parent, false);
            return  new CategoriasActivityFragment.CategoriaHolder(view);
        }

        @Override
        public void onBindViewHolder(CategoriasActivityFragment.CategoriaHolder holder, int position) {
            Categoria categoria = mCategorias.get(position);
            //Enlazar widgets
            holder.bindVideo(categoria);
        }

        @Override
        public int getItemCount() {
            return mCategorias.size();
        }
    }

}
