package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		ChessPiece[][] pieces;
		
		while(!chessMatch.isCheckMate())
		{
			try
			{
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.println("Origem: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				pieces = chessMatch.getPieces();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.println("Para: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if(capturedPiece != null)
					captured.add(capturedPiece);
				
				if(chessMatch.getPromoted() != null)
				{
					System.out.println("Escolha para qual peca voce quer promover: ");
					System.out.println("B - Bispo \nH - Cavalo \nR - Torre \nQ - Rainha");
					String type = sc.nextLine().toUpperCase();
					while(!type.equals("B") && !type.equals("H") && !type.equals("R") && !type.equals("Q")) {
						UI.clearScreen();
						UI.printBoard(pieces, possibleMoves);
						System.out.println("Valor Invalido! Escolha para qual peca voce quer promover: ");
						System.out.println("B - Bispo \nH - Cavalo \nR - Torre \nQ - Rainha");
						type = sc.nextLine().toUpperCase();
					}
					chessMatch.replacePromotedPiece(type);
				}
			}
			catch(ChessException e)
			{
				System.out.println();
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e)
			{
				System.out.println();
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			UI.clearScreen();
			UI.printMatch(chessMatch, captured);
		}
	}

}
