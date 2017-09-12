package com.devart.fahed.developer.pruebastreaming01;

import android.support.v4.app.Fragment;
import android.os.Bundle;
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
public class PrincipalFragment extends Fragment {
    private View rootView;

    private RecyclerView mRecienteRecyclerView;
    private VideoAdapter mAdapterReciente;

    private RecyclerView mTendenciaRecyclerView;
    private VideoAdapter mAdapterTendencia;

    private RecyclerView mMiListaRecyclerView;
    private VideoAdapter mAdapterMiLista;


    public PrincipalFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_principal, container, false);

        mRecienteRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvRecientes);
        mTendenciaRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvTendencia);
        mMiListaRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvMiLista);

        mRecienteRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mTendenciaRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mMiListaRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        updateRecientesUI();
        updateTendenciasUI();
        updateMiListaUI();

        return rootView;
    }

    private void updateRecientesUI(){

        List<Video> videos= new ArrayList<>() ;
        for (int i=0;i<25;i++){
            Video video = new Video();
            video.setPortada("Portado");
            video.setTitulo("Titulo "+(i+1));
            video.setVisualizaciones((100+i) + " VISUALIZACIONES");
            videos.add(video);
        }

        if (mAdapterReciente == null) {
            mAdapterReciente = new VideoAdapter(videos);
            mRecienteRecyclerView.setAdapter(mAdapterReciente);
        }else{
            //Actualizamos solo el item que cambio en el recycler View

            //mAdapter.notifyItemChanged(mItemUpdatePosition);
            //mItemUpdatePosition = RecyclerView.NO_POSITION;
        }

    }

    private void updateTendenciasUI(){

        List<Video> videos= new ArrayList<>() ;
        for (int i=0;i<25;i++){
            Video video = new Video();
            video.setPortada("Portado");
            video.setTitulo("Titulo "+(i+1));
            video.setVisualizaciones((100+i) + " VISUALIZACIONES");
            videos.add(video);
        }

        if (mAdapterTendencia == null) {
            mAdapterTendencia = new VideoAdapter(videos);
            mTendenciaRecyclerView.setAdapter(mAdapterTendencia);
        }else{
            //Actualizamos solo el item que cambio en el recycler View

            //mAdapter.notifyItemChanged(mItemUpdatePosition);
            //mItemUpdatePosition = RecyclerView.NO_POSITION;
        }

    }

    private void updateMiListaUI(){

        List<Video> videos= new ArrayList<>() ;
        for (int i=0;i<25;i++){
            Video video = new Video();
            video.setPortada("Portado");
            video.setTitulo("Titulo "+(i+1));
            video.setVisualizaciones((100+i) + " VISUALIZACIONES");
            videos.add(video);
        }

        if (mAdapterMiLista == null) {
            mAdapterMiLista = new VideoAdapter(videos);
            mMiListaRecyclerView.setAdapter(mAdapterMiLista);
        }else{
            //Actualizamos solo el item que cambio en el recycler View

            //mAdapter.notifyItemChanged(mItemUpdatePosition);
            //mItemUpdatePosition = RecyclerView.NO_POSITION;
        }

    }

    private class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Video mVideo;

        private TextView mTituloTextView;
        private TextView mVisualizacionTextView;
        private ImageView mPortadaImageView;

        public VideoHolder(View itemView) {
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

    private class VideoAdapter extends RecyclerView.Adapter<VideoHolder>{

        private List<Video> mVideos;

        public VideoAdapter(List<Video> videos){
            mVideos = videos;
        }

        @Override
        public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.lista_item_video,parent, false);
            return  new VideoHolder(view);
        }

        @Override
        public void onBindViewHolder(VideoHolder holder, int position) {
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
