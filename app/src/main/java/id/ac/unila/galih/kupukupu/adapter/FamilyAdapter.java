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

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unila.galih.kupukupu.R;
import id.ac.unila.galih.kupukupu.model.KupuKupu;
import id.ac.unila.galih.kupukupu.util.OnItemClickListener;

/**
 * Created by japra_awok on 16/04/2017.
 */

public class FamilyAdapter extends RecyclerView.Adapter<FamilyAdapter.ViewHolder>{

    private Context context;
    private List<String> mFamilies;
    private OnItemClickListener clickListener;

    public void setClickListener(OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public FamilyAdapter(Context context, List<String> families) {
        this.context = context;
        this.mFamilies = families;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kupu2_list_row, parent, false);
        return new FamilyAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String famili = mFamilies.get(position);

        Picasso.with(context)
                .load(R.mipmap.ic_launcher)
                //.load("file:///android_asset/image/appias_libythea.png")
                //.resize(100, 100)
                //.onlyScaleDown() // the image will only be resized if it's bigger than 6000x2000 pixels.
                //.placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .into(holder.ivGbr);
        holder.tvNamaUmum.setText(famili);
    }

    @Override
    public int getItemCount() {
        return mFamilies == null ? 0 : mFamilies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        @BindView(R.id.ivGbr) ImageView ivGbr;
        @BindView(R.id.tvNamaUmum) TextView tvNamaUmum;

        public ViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
}
