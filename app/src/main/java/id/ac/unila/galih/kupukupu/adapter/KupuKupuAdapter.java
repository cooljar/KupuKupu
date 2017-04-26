package id.ac.unila.galih.kupukupu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.ac.unila.galih.kupukupu.R;
import id.ac.unila.galih.kupukupu.model.KupuKupu;
import id.ac.unila.galih.kupukupu.util.OnItemClickListener;

/**
 * Created by japra_awok on 30/09/2016.
 */

public class KupuKupuAdapter extends RecyclerView.Adapter<KupuKupuAdapter.ViewHolder> {

    private Context context;
    private List<KupuKupu> kupuKupuList;
    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public KupuKupuAdapter(Context context, List<KupuKupu> kupuKupuList) {
        this.context = context;
        this.kupuKupuList = kupuKupuList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kupu2_list_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        KupuKupu kupukupu = kupuKupuList.get(position);
        String gambar = kupukupu.gambar[0];
        Picasso.with(context)
                .load("file:///android_asset/image/"+ gambar)
                //.load("file:///android_asset/image/appias_libythea.png")
                //.resize(100, 100)
                //.onlyScaleDown() // the image will only be resized if it's bigger than 6000x2000 pixels.
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .into(holder.ivGbr);
        holder.tvNamaUmum.setText(kupukupu.nama_lokal);
    }

    @Override
    public int getItemCount() {
        return kupuKupuList == null ? 0 : kupuKupuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        public ImageView ivGbr;
        public TextView tvNamaUmum;

        public ViewHolder(View view) {
            super(view);
            ivGbr = (ImageView) view.findViewById(R.id.ivGbr);
            tvNamaUmum = (TextView) view.findViewById(R.id.tvNamaUmum);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
}
