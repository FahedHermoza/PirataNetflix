package com.devart.fahed.developer.pruebastreaming01;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetalleCategoriaActivityFragment extends Fragment {

    private View rootView;
    private RecyclerView mDetalleCategoriaRecyclerView;
    private DetalleCategoriaAdapter mAdapter;
    private final static int COLUMNAS_RECYCLER_VIEW = 2;


    public DetalleCategoriaActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detalle_categoria, container, false);

        mDetalleCategoriaRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvDetalleCategoria);
        mDetalleCategoriaRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), COLUMNAS_RECYCLER_VIEW));



        updateUI();
        return rootView;
    }

    private void updateUI(){

        List<Video> videos= new ArrayList<>() ;
        for (int i=0;i<25;i++){
            Video video = new Video();
            video.setPortada("Portado");
            video.setTitulo("Titulo "+(i+1));
            video.setVisualizaciones((100+i) + " VISUALIZACIONES");
            videos.add(video);
        }

        if (mAdapter == null) {
            mAdapter = new DetalleCategoriaAdapter(videos);
            mDetalleCategoriaRecyclerView.setAdapter(mAdapter);
        }else{
            //Actualizamos solo el item que cambio en el recycler View

            //mAdapter.notifyItemChanged(mItemUpdatePosition);
            //mItemUpdatePosition = RecyclerView.NO_POSITION;
        }

    }

    private class DetalleCategoriaHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Video mVideo;

        private TextView mTituloTextView;
        private TextView mVisualizacionTextView;
        private ImageView mPortadaImageView;

        public DetalleCategoriaHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mTituloTextView = (TextView) itemView.findViewById(R.id.tvTituloItemRecientes);
            mVisualizacionTextView = (TextView) itemView.findViewById(R.id.tvVisualizacionesRecientes);
            mPortadaImageView = (ImageView) itemView.findViewById(R.id.ivPortadasRecientes);
        }

        public void bindVideo(Video video){
            mVideo = video;
            mTituloTextView.setText(mVideo.getTitulo());
            mVisualizacionTextView.setText(mVideo.getVisualizaciones());
            mPortadaImageView.setImageDrawable(getResources().getDrawable(R.mipmap.ejemplo_portadas));
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mVideo.getTitulo() +" clicekd!", Toast.LENGTH_SHORT).show();
        }
    }

    private class DetalleCategoriaAdapter extends RecyclerView.Adapter<DetalleCategoriaActivityFragment.DetalleCategoriaHolder>{

        private List<Video> mVideos;

        public DetalleCategoriaAdapter(List<Video> videos){
            mVideos = videos;
        }

        @Override
        public DetalleCategoriaActivityFragment.DetalleCategoriaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.lista_item_video,parent, false);
            return  new DetalleCategoriaActivityFragment.DetalleCategoriaHolder(view);
        }

        @Override
        public void onBindViewHolder(DetalleCategoriaActivityFragment.DetalleCategoriaHolder holder, int position) {
            Video video = mVideos.get(position);
            //Enlazar widgets
            holder.bindVideo(video);
        }

        @Override
        public int getItemCount() {
            return mVideos.size();
        }

    }
}
