package edu.eci.arsw.threads;

import java.util.LinkedList;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

public class ServidorThread extends Thread{
	private int ini,fin;
	private HostBlacklistsDataSourceFacade skds;
	private int BLACK_LIST_ALARM_COUNT=5;
	private String ip;
	private int ocurriencias;
	private int check;
	private LinkedList<Integer> blackList;
	
	public ServidorThread(int ini, int fin, HostBlacklistsDataSourceFacade skds, String ip) {
		this.ini=ini;
		this.fin=fin;
		this.skds=skds;
		this.ip=ip;
	}

	public void run() {
		int ocurrencesCount = 0;
		blackList=new LinkedList<>();
		for (int i=ini;i<fin && ocurrencesCount<BLACK_LIST_ALARM_COUNT;i++){
            check++;
            if (skds.isInBlackListServer(i, ip)){
            	
            	blackList.add(i);
                ocurriencias++;
            }
        }
		
	}

	public int numeroOcurrencias() {
		return ocurriencias;
	}
	public int numeroCheck() {
		return check;
	}
	public LinkedList<Integer> listaNegra(){
		return blackList;
	}

}
