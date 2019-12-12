package tresenraya;

import java.util.Scanner;

public class TresEnRaya {

	private static Scanner scanner;
	
	public static void main(String[] args) {

		System.out.println("Tres en Raya\n");
		scanner = new Scanner(System.in);
		int numero = 0;
		String player1 = null;
		String player2 = null;
		System.out.print("Elige con qué ficha quieres que juegue cada jugador");
		System.out.println("\n[1] - J1 = X ; J2 = O");
		System.out.println("[2] - J1 = O ; J2 = X\n");
		int eleccionFicha;
		
		do {
			
			System.out.print("Elección: ");
			eleccionFicha = scanner.nextInt();
			System.out.println("\n------------------------------\n");
			
		} while (eleccionFicha != 1 && eleccionFicha != 2);
		
		if (eleccionFicha == 1) {
			
			player1 = "X";
			System.out.println("Jugador 1, juegas con la ficha X");
			player2 = "O";
			System.out.println("Jugador 2, juegas con la ficha O");
			System.out.println("\n------------------------------\n");
			
		} else if (eleccionFicha == 2) {
			
			player1 = "O";
			System.out.println("Jugador 1, juegas con la ficha O");
			player2 = "X";
			System.out.println("Jugador 2, juegas con la ficha X");
			System.out.println("\n------------------------------\n");
		}
		
		int turnos;
		int opcion;
		boolean existeGanador = false;
		String [][] tablero = new String [3][3];
		System.out.println("Opciones de juego");
		System.out.println("[1] - Jugador vs Jugador");
		System.out.println("[2] - Jugador vs BOT");
		System.out.println("[3] - BOT vs BOT");
		System.out.println("[9] - Salir\n");
		
		do {
			
			System.out.print("Elige una opción: ");
			opcion = scanner.nextInt();
			System.out.println("\n------------------------------\n");
			
		} while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 9);
		
		do {
			
			if (opcion == 1) {
			
				do {
					
					System.out.println("Jugador vs Jugador");
					turnos = 1;	
					tablero = imprimeTablero(valoresTablero(tablero));
				
					do {
					
						//TIRA J1		
						if (turnos%2!=0) {
							System.out.print("\nTurno " + (turnos) );
							System.out.print("\nTurno jugador 1, selecciona casilla para tu ficha: ");
							int seleccion = scanner.nextInt();
							
								switch (seleccion) {
									
									case 1: seleccion=1;
										
										tablero[2][0] = player1;
										turnos++;
										break;
											
									case 2: seleccion=2; 
										
										tablero[2][1] = player1;
										turnos++;
										break;
										
									case 3: seleccion=3; 
									
										tablero[2][2] = player1;
										turnos++;
										break;
										
									case 4: seleccion=4; 
										
										tablero[1][0] = player1;
										turnos++;
										break;
										
									case 5: seleccion=5; 
										
										tablero[1][1] = player1;
										turnos++;
										break;
										
									case 6: seleccion=6; 
										
										tablero[1][2] = player1;
										turnos++;
										break;
										
									case 7: seleccion=7; 
										
										tablero[0][0] = player1;
										turnos++;
										break;
										
									case 8: seleccion=8; 
										
										tablero[0][1] = player1;
										turnos++;
										break;
										
									case 9: seleccion=9; 
										
										tablero[0][2] = player1;
										turnos++;
										break;
								
								}//IMPRIME TABLERO
								imprimeTablero(tablero);
						}
					
						//TIRA J2
						else if (turnos%2==0) {
							System.out.print("\nTurno " + (turnos) );
							System.out.print("\nTurno jugador 2, selecciona casilla para tu ficha: ");
							int seleccion2 = scanner.nextInt();
					
								switch (seleccion2) {
									
									case 1: seleccion2=1;
										
										tablero[2][0] = player2;
										turnos++;
										break;
											
									case 2: seleccion2=2; 
										
										tablero[2][1] = player2;
										turnos++;
										break;
										
									case 3: seleccion2=3; 
										
										tablero[2][2] = player2;
										turnos++;
										break;
										
									case 4: seleccion2=4; 
										
										tablero[1][0] = player2;
										turnos++;
										break;
										
									case 5: seleccion2=5; 
										
										tablero[1][1] = player2;
										turnos++;
										break;
										
									case 6: seleccion2=6; 
										
										tablero[1][2] = player2;
										turnos++;
										break;
										
									case 7: seleccion2=7; 
										
										tablero[0][0] = player2;
										turnos++;
										break;
										
									case 8: seleccion2=8; 
										
										tablero[0][1] = player2;
										turnos++;
										break;
										
									case 9: seleccion2=9; 
										
										tablero[0][2] = player2;
										turnos++;
										break;
										
								}//IMPRIME TABLERO
								imprimeTablero(tablero);
						}
				
						//WINS
						existeGanador = wins(tablero, player1, player2, turnos);
				
					} while (turnos < 10 && existeGanador == false);
					
						if (turnos == 10 && existeGanador == false) {
						
							System.out.println("\n¡HAY UN EMPATE!");
						}
				
					System.out.println("\nPulsa [1] si quieres volver a jugar contra otro jugador");
					System.out.println("Pulsa [2] si quieres jugar contra un BOT");
					System.out.println("Pulsa [3] si quieres generar un juego BOT vs BOT");
					System.out.println("Pulsa [9] si quieres salir\n");
					
					do {
						
						System.out.print("Elige una opción: ");
						opcion = scanner.nextInt();
						System.out.println("\n------------------------------\n");
						
					} while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 9);
					
				} while (opcion == 1);
			
			}	
			else if (opcion == 2) {
				
				do {
		
					System.out.println("Jugador vs BOT");			
					turnos = 1;		
					tablero = imprimeTablero(valoresTablero(tablero));
					
					do {
						
						//TIRA J1		
						if (turnos%2!=0) {
							System.out.print("\nTurno " + (turnos) );
							System.out.print("\nTurno humano, selecciona casilla para tu ficha: ");
							int seleccion = scanner.nextInt();
							
								switch (seleccion) {
									
									case 1: seleccion=1;
										
										tablero[2][0] = player1;
										turnos++;
										break;
											
									case 2: seleccion=2; 
										
										tablero[2][1] = player1;
										turnos++;
										break;
										
									case 3: seleccion=3; 
										
										tablero[2][2] = player1;
										turnos++;
										break;
										
									case 4: seleccion=4; 
										
										tablero[1][0] = player1;
										turnos++;
										break;
										
									case 5: seleccion=5; 
										
										tablero[1][1] = player1;
										turnos++;
										break;
										
									case 6: seleccion=6; 
										
										tablero[1][2] = player1;
										turnos++;
										break;
										
									case 7: seleccion=7; 
										
										tablero[0][0] = player1;
											turnos++;
										break;
										
									case 8: seleccion=8; 
										
										tablero[0][1] = player1;
										turnos++;
										break;
										
									case 9: seleccion=9; 
										
										tablero[0][2] = player1;
										turnos++;
										break;
										
								}//IMPRIME TABLERO
								imprimeTablero(tablero);
						}
					
						//TURNO IA	
						else if (turnos%2==0) {
							System.out.print("\nTurno " + (turnos) );
							System.out.print("\nTurno del BOT:\n");
							int seleccionIA = numeroRandom(numero);
								
								switch (seleccionIA) {
										
									case 1: seleccionIA=1;
											
										if ( (tablero[2][0] == player2) || (tablero[2][0] == player1) ) {	
											numero = seleccionIA;		
										}
										else {									
											tablero[2][0] = player2;
											turnos++;
											break;
										}
											
									case 2: seleccionIA=2; 
										
										if ( (tablero[2][1] == player2) || (tablero[2][1] == player1) )	{										
											numero = seleccionIA;
										}
										else {								
											tablero[2][1] = player2;
											turnos++;
											break;								
										}							
										
									case 3: seleccionIA=3; 
										
										if ( (tablero[2][2] == player2) || (tablero[2][2] == player1) )	{										
											numero = seleccionIA;
										}
										else {									
											tablero[2][2] = player2;
											turnos++;
											break;									
										}
																					
									case 4: seleccionIA=4; 
										
										if ( (tablero[1][0] == player2) || (tablero[1][0] == player1) )	{										
											numero = seleccionIA;
										}
										else {							
											tablero[1][0] = player2;
											turnos++;
											break;								
										}										
											
									case 5: seleccionIA=5; 
										
										if ( (tablero[1][1] == player2) || (tablero[1][1] == player1) )	{	
											numero = seleccionIA;
										}
										else {							
											tablero[1][1] = player2;
											turnos++;
											break;						
										}											
										
									case 6: seleccionIA=6; 
										
										if ( (tablero[1][2] == player2) || (tablero[1][2] == player1) )	{										
											numero = seleccionIA;					
										}
										else {										
											tablero[1][2] = player2;
											turnos++;
											break;
										}
																					
									case 7: seleccionIA=7; 
										
										if ( (tablero[0][0] == player2) || (tablero[0][0] == player1) )	{									
											numero = seleccionIA;		
										}
										else {											
											tablero[0][0] = player2;
											turnos++;
											break;
										}
																					
									case 8: seleccionIA=8; 
										
										if ( (tablero[0][1] == player2) || (tablero[0][1] == player1) )	{			
											numero = seleccionIA;
										}
										else {			
											tablero[0][1] = player2;
											turnos++;
											break;
										}
																					
									case 9: seleccionIA=9; 
									
										if ( (tablero[0][2] == player2) || (tablero[0][2] == player1) )	{			
											numero = seleccionIA;						
										}
										else {									
											tablero[0][2] = player2;
											turnos++;
											break;
										}	
										
								}//IMPRIME TABLERO
								imprimeTablero(tablero);	
						}
					
						//WINS
						existeGanador = wins(tablero, player1, player2, turnos);
					
					} while (turnos < 10 && existeGanador == false);
					
						if (turnos == 10 && existeGanador == false) {
							System.out.println("\n¡HAY UN EMPATE!");
						}
					
					System.out.println("\nPulsa [1] si quieres jugar contra otro jugador");
					System.out.println("Pulsa [2] si quieres volver a jugar contra un BOT");
					System.out.println("Pulsa [3] si quieres generar un juego BOT vs BOT");
					System.out.println("Pulsa [9] si quieres salir\n");
					
					do {
						
						System.out.print("Elige una opción: ");
						opcion = scanner.nextInt();
						System.out.println("\n------------------------------\n");
						
					} while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 9);
					
				} while (opcion == 2);
				
			}
			
			else if (opcion == 3) {
					
				do {
		
					System.out.println("BOT 1 vs BOT 2");
					turnos = 1;	
					tablero = imprimeTablero(valoresTablero(tablero));
						
					do {
							
						//TURNO IA1	
						if (turnos%2!=0) {
							System.out.print("\nTurno " + (turnos) );
							System.out.print("\nTurno del BOT 1: ");
							int seleccionIA1 = numeroRandom(numero);
									
								switch (seleccionIA1) {
									
									case 1: seleccionIA1=1;
													
										if ( (tablero[2][0] == player2) || (tablero[2][0] == player1) ) {			
											numero = seleccionIA1;							
										}
										else {												
											tablero[2][0] = player1;
											turnos++;
											break;			
										}
																									
									case 2: seleccionIA1=2; 
												
										if ( (tablero[2][1] == player2) || (tablero[2][1] == player1) )	{											
											numero = seleccionIA1;							
										}
										else {												
											tablero[2][1] = player1;
											turnos++;
											break;						
										}												
												
									case 3: seleccionIA1=3; 
									
										if ( (tablero[2][2] == player2) || (tablero[2][2] == player1) )	{		
											numero = seleccionIA1;										
										}
										else {												
											tablero[2][2] = player1;
											turnos++;
											break;	
										}
																								
									case 4: seleccionIA1=4; 
												
										if ( (tablero[1][0] == player2) || (tablero[1][0] == player1) )	{										
											numero = seleccionIA1;								
										}
										else {											
											tablero[1][0] = player1;
											turnos++;
											break;						
										}												
													
									case 5: seleccionIA1=5; 
												
										if ( (tablero[1][1] == player2) || (tablero[1][1] == player1) )	{								
											numero = seleccionIA1;								
										}
										else {													
											tablero[1][1] = player1;
											turnos++;
											break;								
										}
																							
									case 6: seleccionIA1=6; 
												
										if ( (tablero[1][2] == player2) || (tablero[1][2] == player1) )	{											
											numero = seleccionIA1;						
										}
										else {											
											tablero[1][2] = player1;
											turnos++;
											break;
										}
																									
									case 7: seleccionIA1=7; 
												
										if ( (tablero[0][0] == player2) || (tablero[0][0] == player1) )	{						
											numero = seleccionIA1;
										}
										else {													
											tablero[0][0] = player1;
											turnos++;
											break;
										}
																								
									case 8: seleccionIA1=8; 
												
										if ( (tablero[0][1] == player2) || (tablero[0][1] == player1) )	{		
											numero = seleccionIA1;
										}
										else {												
											tablero[0][1] = player1;
											turnos++;
											break;	
										}
																								
									case 9: seleccionIA1=9; 
												
										if ( (tablero[0][2] == player2) || (tablero[0][2] == player1) )	{				
											numero = seleccionIA1;
										}
										else {											
											tablero[0][2] = player1;
											turnos++;
											break;
										}
											
								}//IMPRIME TABLERO
								imprimeTablero(tablero);	
						}
							
						//TURNO IA2
						else if (turnos%2==0) {
							System.out.print("\nTurno " + (turnos) );
							System.out.print("\nTurno del BOT 2: ");
							int seleccionIA2 = numeroRandom(numero);
								
								switch (seleccionIA2) {
								
									case 1: seleccionIA2=1;
											
										if ( (tablero[1][0] == player2) || (tablero[1][0] == player1) ) {	
											numero = seleccionIA2;		
										}
										else {										
											tablero[1][0] = player2;
											turnos++;
											break;	
										}											
											
									case 2: seleccionIA2=2; 
										
										if ( (tablero[2][1] == player2) || (tablero[2][1] == player1) )	{
											numero = seleccionIA2;	
										}
										else {
											tablero[2][1] = player2;
											turnos++;
											break;	
										}										
										
									case 3: seleccionIA2=3; 
										
										if ( (tablero[2][2] == player2) || (tablero[2][2] == player1) )	{	
											numero = seleccionIA2;										
										}
										else {										
											tablero[2][2] = player2;
											turnos++;
											break;
										}
																				
									case 4: seleccionIA2=4; 
										
										if ( (tablero[1][0] == player2) || (tablero[1][0] == player1) )	{				
											numero = seleccionIA2;								
										}
										else {									
											tablero[1][0] = player2;
											turnos++;
											break;		
										}
																				
									case 5: seleccionIA2=5; 
										
										if ( (tablero[1][1] == player2) || (tablero[1][1] == player1) )	{				
											numero = seleccionIA2;									
										}
										else {												
											tablero[1][1] = player2;
											turnos++;
											break;		
										}
																				
									case 6: seleccionIA2=6; 
										
										if ( (tablero[1][2] == player2) || (tablero[1][2] == player1) )	{				
											numero = seleccionIA2;						
										}
										else {											
											tablero[1][2] = player2;
											turnos++;
											break;
										}										
										
									case 7: seleccionIA2=7; 
									
										if ( (tablero[0][0] == player2) || (tablero[0][0] == player1) )	{			
											numero = seleccionIA2;						
										}
										else {											
											tablero[0][0] = player2;
											turnos++;
											break;
										}
																				
									case 8: seleccionIA2=8; 
										
										if ( (tablero[0][1] == player2) || (tablero[0][1] == player1) )	{				
											numero = seleccionIA2;
										}
										else {										
											tablero[0][1] = player2;
											turnos++;
											break;
										}									
										
									case 9: seleccionIA2=9; 
										
										if ( (tablero[0][2] == player2) || (tablero[0][2] == player1) )	{										
											numero = seleccionIA2;
										}
										else {										
											tablero[0][2] = player2;
											turnos++;
											break;					
										}	
							
								}//IMPRIME TABLERO
								imprimeTablero(tablero);
						}
						
						//WINS
						existeGanador = wins(tablero, player1, player2, turnos);
							
					} while (turnos < 10 && existeGanador == false);
						
						if (turnos == 10 && existeGanador == false) {
							System.out.println("\n¡HAY UN EMPATE!");						
						}
						
					System.out.println("\nPulsa [1] si quieres jugar contra otro jugador");
					System.out.println("Pulsa [2] si quieres jugar contra un BOT");
					System.out.println("Pulsa [3] si quieres volver a generar un juego BOT vs BOT");
					System.out.println("Pulsa [9] si quieres salir\n");				
					
					do {
						
						System.out.print("Elige una opción: ");
						opcion = scanner.nextInt();
						System.out.println("\n------------------------------\n");
						
					} while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 9);
						
				} while (opcion == 3);
					
			}
			
		} while ( (opcion == 1) || (opcion == 2) || (opcion == 3) );
		
		do {
				
			System.out.println("¡Gracias por jugar!");
			break;
				
		} while (opcion == 9);	
	}
	
	public static int numeroRandom(int numero) {
		
		numero = (int) ( (Math.random() * 9 + 1) );
		return numero;	
	}
	
	public static String[][] valoresTablero(String [][] tablero) {

		tablero = new String[3][3];
		tablero[0][0] = "7";
		tablero[0][1] = "8";
		tablero[0][2] = "9";
		tablero[1][0] = "4";
		tablero[1][1] = "5";
		tablero[1][2] = "6";
		tablero[2][0] = "1";
		tablero[2][1] = "2";
		tablero[2][2] = "3";
		return tablero;
	}

	public static String[][] imprimeTablero(String [][] tablero) {

		valoresTablero(tablero);
		for(int i = 0; i<tablero.length; i++) {
			System.out.println("\n" + "| " + tablero[i][0] + " | " + tablero[i][1] + " | " + tablero[i][2] + " |");
		} return tablero;
	}

	public static boolean wins(String [][] tablero, String player1, String player2, int turnos) {

		valoresTablero(tablero);
		//LINEA 0 GANA
		if ( ( (tablero[0][0] == player1) && (tablero[0][1] == player1) && (tablero[0][2] == player1) ) || ( (tablero[0][0] == player2) && (tablero[0][1] == player2) && (tablero[0][2] == player2) ) ) {

			if (turnos%2==0) {

				System.out.println("\nHa ganado el jugador de las " + player1 + "!");
				return true;

			} else if (turnos%2!=0) {

				System.out.println("\nHa ganado el jugador de las " + player2 + "!");
				return true;
			}
			
		} //LINEA 1 GANA
		else if ( ( (tablero[1][0] == player1) && (tablero[1][1] == player1) && (tablero[1][2] == player1) ) || ( (tablero[1][0] == player2) && (tablero[1][1] == player2) && (tablero[1][2] == player2) ) ) {

			if (turnos%2==0) {

				System.out.println("\nHa ganado el jugador de las " + player1 + "!");
				return true;

			} else if (turnos%2!=0) {

				System.out.println("\nHa ganado el jugador de las " + player2 + "!");
				return true;
			}

		} //LINEA 2 GANA
		else if ( ( (tablero[2][0] == player1) && (tablero[2][1] == player1) && (tablero[2][2] == player1) ) || ( (tablero[2][0] == player2) && (tablero[2][1] == player2) && (tablero[2][2] == player2) ) ) {

			if (turnos%2==0) {

				System.out.println("\nHa ganado el jugador de las " + player1 + "!");
				return true;

			} else if (turnos%2!=0) {

				System.out.println("\nHa ganado el jugador de las " + player2 + "!");
				return true;
			}

		} //COLUMNA 0 GANA
		else if ( ( (tablero[0][0] == player1) && (tablero[1][0] == player1) && (tablero[2][0] == player1) ) || ( (tablero[0][0] == player2) && (tablero[1][0] == player2) && (tablero[2][0] == player2) ) ) {

			if (turnos%2==0) {

				System.out.println("\nHa ganado el jugador de las " + player1 + "!");
				return true;

			} else if (turnos%2!=0) {

				System.out.println("\nHa ganado el jugador de las " + player2 + "!");
				return true;
			}

		} //COLUMNA 1 GANA
		else if ( ( (tablero[0][1] == player1) && (tablero[1][1] == player1) && (tablero[2][1] == player1) ) || ( (tablero[0][1] == player2) && (tablero[1][1] == player2) && (tablero[2][1] == player2) ) ) {

			if (turnos%2==0) {

				System.out.println("\nHa ganado el jugador de las " + player1 + "!");
				return true;

			} else if (turnos%2!=0) {

				System.out.println("\nHa ganado el jugador de las " + player2 + "!");
				return true;
			}

		} //COLUMNA 2 GANA
		else if ( ( (tablero[0][2] == player1) && (tablero[1][2] == player1) && (tablero[2][2] == player1) ) || ( (tablero[0][2] == player2) && (tablero[1][2] == player2) && (tablero[2][2] == player2) ) ) {

			if (turnos%2==0) {

				System.out.println("\nHa ganado el jugador de las " + player1 + "!");
				return true;

			} else if (turnos%2!=0) {

				System.out.println("\nHa ganado el jugador de las " + player2 + "!");
				return true;
			}

		} //DIAGONAL IZQUIERDA-DERECHA GANA
		else if ( ( (tablero[0][0] == player1) && (tablero[1][1] == player1) && (tablero[2][2] == player1) ) || ( (tablero[0][0] == player2) && (tablero[1][1] == player2) && (tablero[2][2] == player2) ) ) {

			if (turnos%2==0) {

				System.out.println("\nHa ganado el jugador de las " + player1 + "!");
				return true;

			} else if (turnos%2!=0) {

				System.out.println("\nHa ganado el jugador de las " + player2 + "!");
				return true;
			}

		} //DIAGONAL DERECHA-IQUIERDA GANA
		else if ( ( (tablero[0][2] == player1) && (tablero[1][1] == player1) && (tablero[2][0] == player1) ) || ( (tablero[0][2] == player2) && (tablero[1][1] == player2) && (tablero[2][0] == player2) ) ) {

			if (turnos%2==0) {

				System.out.println("\nHa ganado el jugador de las " + player1 + "!");
				return true;
				
			} else if (turnos%2!=0) {

				System.out.println("\nHa ganado el jugador de las " + player2 + "!");
				return true;
			}
		}
		return false;
	}
}