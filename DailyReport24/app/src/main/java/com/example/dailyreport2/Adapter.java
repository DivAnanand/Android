  package com.example.dailyreport2;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private Context context;
    private ArrayList<Model> arrayList;
    // dataBase object
    DatabaseHelper databaseHelper;


    public Adapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        //initialse here
        databaseHelper = new DatabaseHelper(context);


    }
        @NonNull
        @Override
        public Holder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){

            View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);

            return new Holder(view);

        }

        @Override
        public void onBindViewHolder (@NonNull Holder holder,int position){

            Model model = arrayList.get(position);
            // get for view
             final String id = model.getId();
             final String date = model.getDate();
             final String  project = model.getProject();
             final String  challenge = model.getChallenge();
             final String difficulty = model.getDifficulty();
             final String staffname = model.getStaffname();
             final String time = model.getTime();
             final String village = model.getVillage();
            final String persongroup = model.getPersongroup();
            final String actionpoint = model.getActionpoint();
            final String meetingpoint = model.getMeetingpoint();
            final String nextdayplanning = model.getNextdayPlanning();
            //set view
            holder.date.setText(date);
            holder.project.setText(project);
            holder.challenge.setText(challenge);
            holder.difficulty.setText(difficulty);
            holder.staffname.setText(staffname);
            holder.time.setText(time);
            holder.village.setText(village);
            holder.persongroup.setText(persongroup);
            holder.actionpoint.setText(actionpoint);
            holder.meetingpoint.setText(meetingpoint);
            holder.nextdayplanning.setText(nextdayplanning);

            holder.editButton.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                    editDialog(
                            ""+id,
                            ""+date,
                            ""+project,
                            ""+challenge,
                            ""+difficulty,
                            ""+staffname,
                            ""+time,
                            ""+village,
                            ""+persongroup,
                            ""+meetingpoint,
                            ""+actionpoint,
                            ""+nextdayplanning
                     );

                }
            });
            // when long press item show an alert on dailog box an item

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    deleteDialog(
                            ""+id
                    );
                    return false;
                }
            });
        }

    private void deleteDialog(final String id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete");
        builder.setMessage("Are you want to delete");
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_delete);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
              public void onClick(DialogInterface dialogInterface, int i) {
                       databaseHelper.deleteInfo(id);
                       ((MainActivity)context).onResume();
                Toast.makeText(context," Delete Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                 dialog.cancel();
            }
        });
        builder.create().show();
    }

    private void editDialog(final String id,final String date,final String project,final String challenge,final String difficulty,final String staffname, final String time, final String village, final String persongroup, String meetingpoint, final String actionpoint, final String nextdayplanning) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Update");
        builder.setMessage("Are you want to update?");
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_edit);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(context, EditRecordActivity2.class);
                intent.putExtra("ID", id);
                intent.putExtra("DATE",date);
                intent.putExtra("PROJECT",project);
                intent.putExtra("CHALLENGE",challenge);
                intent.putExtra("DIFFICULTY",difficulty);
                intent.putExtra("STAFFNAME",staffname);
                intent.putExtra("TIME",time);
                intent.putExtra("VILLAGE",village);
                intent.putExtra("PERSONGROUP",persongroup);
                intent.putExtra("MEETINGPOINT",persongroup);
                intent.putExtra("ACTIONPOINT",actionpoint);
                intent.putExtra("NEXTDAYPLANNING",nextdayplanning);
                intent.putExtra("editMode",true);

                context.startActivity(intent);

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.create().show();
    }

    @Override
        public int getItemCount () {
            return arrayList.size();
        }

        class Holder extends RecyclerView.ViewHolder {

            TextView  date,project,challenge,difficulty,staffname,time, village, persongroup, actionpoint, meetingpoint, nextdayplanning;
            ImageButton editButton;

            public Holder(@NonNull View itemView) {

                super(itemView);
                date = itemView.findViewById(R.id.date);
                project = itemView.findViewById(R.id.project);
                challenge = itemView.findViewById(R.id.challenge);
                difficulty = itemView.findViewById(R.id.difficulty);
                staffname = itemView.findViewById(R.id.staffname);
                time = itemView.findViewById(R.id.time);
                village = itemView.findViewById(R.id.village);
                persongroup = itemView.findViewById(R.id.personGroup);
                actionpoint = itemView.findViewById(R.id.actionPoint);
                meetingpoint = itemView.findViewById(R.id.meetingPoint);
                nextdayplanning = itemView.findViewById(R.id.nextDayPlanning);
                editButton = itemView.findViewById(R.id.editBtn);
            }
        }
    }
