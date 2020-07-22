package com.example.task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.example.task2.network.Team
import kotlinx.android.synthetic.main.item_person.view.*

//class PeopleListAdapter(private var people: List<Person>): RecyclerView.Adapter<PeopleListAdapter.PersonItemViewHolder>() {
//    private var listener:OnItemClickListener? = null
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
//            PeopleListAdapter.PersonItemViewHolder {
//        var view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_person, parent, false)
//        //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//        return PersonItemViewHolder(view, listener)
//
//    }
//
//    override fun getItemCount(): Int {
//        return people.size;
//    }
//
//    override fun onBindViewHolder(holder: PeopleListAdapter.PersonItemViewHolder, position: Int) {
//        holder.bind(people[position])
//    }
//    class PersonItemViewHolder(itemView: View, listener: OnItemClickListener?):
//    RecyclerView.ViewHolder(itemView) {
//       // private var person1: Person ?= null
//        init {
//            itemView.setOnClickListener {
//             //   person1?.let { it1 -> listener?.onClick(it1) }
//                listener?.onClick(adapterPosition)
//            }
//        }
//        fun bind(person: Person) {
//            Glide.with(itemView.context).load(person?.urlImage)
//                .into(itemView.civPersonImage)
//            itemView.tvUser.text = person?.name + " " + person?.surname
//        }
//    }
//    interface OnItemClickListener {
//        fun onClick(position: Int)
//    }
//    fun setOnItemClickListener(listener: OnItemClickListener) {
//        this.listener = listener
//    }
//}
class PeopleListAdapter: RecyclerView.Adapter<PeopleListAdapter.PersonItemViewHolder>() {
    private var teams: List<Team> ?= null
    private var listener:OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PeopleListAdapter.PersonItemViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return PersonItemViewHolder(view, listener)

    }

    override fun getItemCount() =  teams?.size?:0;

    override fun onBindViewHolder(holder: PeopleListAdapter.PersonItemViewHolder, position: Int) {
        teams?.get(position)?.let { holder.bind(it) }
    }
    class PersonItemViewHolder(itemView: View, listener: OnItemClickListener?):
        RecyclerView.ViewHolder(itemView) {
        // private var person1: Person ?= null
        init {
            itemView.setOnClickListener {
                //   person1?.let { it1 -> listener?.onClick(it1) }
                listener?.onClick(adapterPosition)
            }
        }
        fun bind(team: Team) {
            itemView.tvUser.text = team.full_name
        }
    }
    interface OnItemClickListener {
        fun onClick(position: Int)
    }
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    fun  setTeams(teams: List<Team>) {
        this.teams = teams
        notifyDataSetChanged()
    }
}