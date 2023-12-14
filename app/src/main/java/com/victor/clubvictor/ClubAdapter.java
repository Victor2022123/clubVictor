package com.victor.clubvictor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ClubViewHolder> {

    private List<Member> members;
    private int selectedPosition = -1;

    private Context context;

    public ClubAdapter(List<Member> members, Context context) {
        this.members = members;
        this.context = context;
    }

    @Override
    public ClubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.miembro_items, parent, false);
        return new ClubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClubViewHolder holder, int position) {
        Member member = members.get(position);
        // Se configura los datos de los elementos de la lista
        holder.idTV.setText(String.valueOf(member.getId()));
        holder.nombreTV.setText(member.getName());

        holder.telefonoTV.setText(member.getPhone());
        holder.ciTV.setText(member.getCi());

        // Configura un OnClickListener en el ViewHolder
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Guarda el índice del elemento seleccionado
                setSelectedPosition(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    class ClubViewHolder extends RecyclerView.ViewHolder {
        // Se declararan los elementos de la vista (Layout user_item.xml)
        TextView idTV, nombreTV, telefonoTV, ciTV;

        public ClubViewHolder(View itemView) {
            super(itemView);
            idTV = itemView.findViewById(R.id.txtItmId);
            nombreTV = itemView.findViewById(R.id.txtItemNombre);
            telefonoTV = itemView.findViewById(R.id.txtItemTel);
            ciTV = itemView.findViewById(R.id.txtItemCi);

        }
    }

}
