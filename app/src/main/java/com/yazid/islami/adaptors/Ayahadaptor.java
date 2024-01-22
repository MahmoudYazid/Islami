package com.yazid.islami.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yazid.islami.R;
import com.yazid.islami.model.DataItem;
import com.yazid.islami.model.ISurahWebOpen;

import java.util.List;

public class Ayahadaptor extends RecyclerView.Adapter<Ayahadaptor.Viewholder> {
    List<DataItem> AyahList;
    public ISurahWebOpen ISurahWebOpenInst;

    public Ayahadaptor (List<DataItem> DataInput){
        this.AyahList=DataInput;

    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_signle_surah_item, parent, false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        DataItem item = AyahList.get(position);
        TextView textViewSurahName_ = holder.itemView.findViewById(R.id.textViewSurahName);
        TextView textViewNumberOfAyah_ = holder.itemView.findViewById(R.id.textViewNumberOfAyah);
        textViewSurahName_.setText(item.getName().toString());
        textViewNumberOfAyah_.setText(item.getNumberOfAyahs().toString());
        textViewSurahName_.setOnClickListener(

                new View.OnClickListener(

                ) {
                    @Override
                    public void onClick(View view) {
                        ISurahWebOpenInst.OpenSurahNumber(item.getNumber().toString());

                    }
                }
        );

    }

    @Override
    public int getItemCount() {
        return AyahList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{
        public Viewholder(@NonNull View itemView) {

            super(itemView);
            TextView NumberOfAyahInSurah = itemView.findViewById(R.id.textViewNumberOfAyah);
            TextView NameOfSurah = itemView.findViewById(R.id.textViewSurahName);
        }


    }

}
