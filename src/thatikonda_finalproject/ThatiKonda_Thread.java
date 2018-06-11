/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thatikonda_finalproject;

/**
 *
 * @author ThatiKonda
 */
class ThatiKonda_Thread extends Thread {

    int T, x;
    ThatiKonda_Move Movetrace;

    ThatiKonda_Thread(int i, ThatiKonda_Move gO) {
        Movetrace = gO;
        T = i;
       
    }

    public void run() {
        Movetrace.moveObject(x, T);

    }

}
