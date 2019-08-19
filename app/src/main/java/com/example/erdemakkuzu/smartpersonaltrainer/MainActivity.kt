package com.example.erdemakkuzu.smartpersonaltrainer

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorFilter
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.choose_workout.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

//    var progressBarr:ProgressBar = R.id.progressBar as ProgressBar

    var progressPercent:Int = 50





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


       // progressBar.progress=75

        displayScreen(-1)








    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }


    fun displayScreen(id:Int){

       val fragment= when (id) {
            R.id.nav_camera -> {
                HomeFragment()


            }
            R.id.nav_gallery -> {

                ChoseWorkoutFragment()

            }
            R.id.nav_slideshow -> {
                HomeFragment()

            }
            R.id.nav_manage -> {
                HomeFragment()

            }
            R.id.nav_share -> {
                HomeFragment()

            }
            R.id.nav_send -> {
                HomeFragment()

            }

            else ->{

                HomeFragment()

            }


        }



        supportFragmentManager.beginTransaction()
                .replace(R.id.contentMain,fragment).commit()




    }





    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        displayScreen(item.itemId)


        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


}
