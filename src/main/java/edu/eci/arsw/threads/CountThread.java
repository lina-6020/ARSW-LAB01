/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThread extends Thread {
	private int iniNum, finNum;
	CountThread(int iniNum, int finNum){
		this.finNum = finNum;
		this.iniNum = iniNum;
	}
	public void run() {
		int i;
		for (i=iniNum;i<=finNum;i++) {
			System.out.println(i);
		}
	}
    
}
