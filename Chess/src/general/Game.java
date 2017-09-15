/*
	Copyright (C) 2010 Petri Tuononen

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package general;
import java.util.*;

import player.Player;
import player.PlayerAI;
  
/**
 * 
 * @author Petri Tuononen
 * @since 26/11/2009
 */
public class Game {
	
	private int whosTurn;
	
	//get player color who's turn it is
	public int getWhosTurn() {
		return whosTurn;
	}

	//set player color who's turn it is
	public void setWhosTurn(int whosTurn) {
		this.whosTurn = whosTurn;
	}

	/**
	 * raffle which player gets which color/side to start with.
	 */
	public void raffleSide(Player player1, Player player2) {
		Random gen = new Random();
		int result = gen.nextInt(2); //0 or 1 (0=white or 1=black)
		player1.setSide(result);
		if (result==0) {
			player2.setSide(1);
		} else {
			player2.setSide(0);
		}
	}
	
	/**
	 * If checkmate occurs, inform players and return true.
	 * @param board
	 * @param move
	 * @param player1
	 * @param player2
	 */
	public boolean checkCheckmate(Board board, Move move, Player player1, Player player2) {
		//AI player is needed for isCheckmate method
		PlayerAI AI = new PlayerAI(board, move, 0);
		//check if player1 is in checkmate
		if (AI.isCheckmate(player1)) {
			String winnerSide;
			if (player1.getSide()==0) {
				winnerSide = "black";
			} else {
				winnerSide = "white";
			}
			System.out.println("Checkmate! " +winnerSide+" won!");
			return true;
		} else if (AI.isCheckmate(player2)) {
			String winnerSide;
			if (player2.getSide()==0) {
				winnerSide = "black";
			} else {
				winnerSide = "white";
			}
			System.out.println("Checkmate! " +winnerSide+" won!");
			return true;
		}
		return false;
	}
	
}
