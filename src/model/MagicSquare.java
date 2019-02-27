package model;

public class MagicSquare {
	private int x;
	int[][] magicSquare;

	public MagicSquare() {
	}

	public void createMagicSquare(String position, String orientation) throws IsNotOddOrNullException, MyException{
			if(x % 2 == 1 && position != null && orientation != null) {
				int row = 0;
				int column = 0;
				int rowAc = 0;
				int colAc = 0;

				magicSquare = new int[x][x];
				if (position.equals("UP")) {
					if (orientation.equals("NO")) {
						row = 0;
						column = x / 2;
						for (int i = 1; i <= (x * x); i++) {
							magicSquare[row][column] = i;
							rowAc = row;
							colAc = column;
							row -= 1;
							column -= 1;
							if (row == -1) {
								row = x - 1;
							}
							if (column == -1) {
								column = x - 1;
							}
							if (magicSquare[row][column] != 0) {
								row = rowAc + 1;
								column = colAc;
							}
						}
					} else if (orientation.equals("NE")) {
						row = 0;
						column = x / 2;

						for (int i = 1; i <= (x * x); i++) {
							magicSquare[row][column] = i;
							rowAc = row;
							colAc = column;
							row -= 1;
							column += 1;
							if (row == -1) {
								row = x - 1;
							}
							if (column == x) {
								column = 0;
							}
							if (magicSquare[row][column] != 0) {
								row = rowAc + 1;
								column = colAc;
							}
						}
					} else if(!orientation.equals("NO") || !orientation.equals("NE")) {
						throw new MyException("La posicion de UP no puede ser llenada en direccion SE o SO");
					}
				}

				if (position.equals("DOWN")) {
					if (orientation.equals("SO")) {
						row = x - 1;
						column = x / 2;

						for (int i = 1; i <= (x * x); i++) {
							magicSquare[row][column] = i;
							rowAc = row;
							colAc = column;
							row += 1;
							column -= 1;
							if (row == x) {
								row = 0;
							}
							if (column == -1) {
								column = x - 1;
							}
							if (column == x) {
								column = 0;
							}
							if (magicSquare[row][column] != 0) {
								row = rowAc - 1;
								column = colAc;
							}
						}
					} else if (orientation.equals("SE")) {
						row = x - 1;
						column = x / 2;

						for (int i = 1; i <= (x * x); i++) {
							magicSquare[row][column] = i;
							rowAc = row;
							colAc = column;
							row += 1;
							column += 1;
							if (row == x) {
								row = 0;
							}
							if (column == -1) {
								column = x - 1;
							}
							if (column == x) {
								column = 0;
							}
							if (magicSquare[row][column] != 0) {
								row = rowAc - 1;
								column = colAc;
							}
						}
					}else if(!orientation.equals("SE") || !orientation.equals("SO")) {
						throw new MyException("La posicion DOWN no se puede llenar en orientaciones diferentes a SO, SE");
					}
				}
				if (position.equals("LEFT")) {
					if (orientation.equals("NO")) {
						row = x / 2;
						column = 0;

						for (int i = 1; i <= (x * x); i++) {
							magicSquare[row][column] = i;
							rowAc = row;
							colAc = column;
							row -= 1;
							column -= 1;
							if (row == -1) {
								row = x - 1;
							}
							if (column == -1) {
								column = x - 1;
							}
							if (magicSquare[row][column] != 0) {
								row = rowAc;
								column = colAc + 1;
							}
						}
					} else if (orientation.equals("SO")) {
						row = x / 2;
						column = 0;

						for (int i = 1; i <= (x * x); i++) {
							magicSquare[row][column] = i;
							rowAc = row;
							colAc = column;
							row += 1;
							column -= 1;
							if (row == x) {
								row = 0;
							}
							if (column == -1) {
								column = x - 1;
							}
							if (column == x) {
								column = 0;
							}
							if (magicSquare[row][column] != 0) {
								row = rowAc;
								column = colAc + 1;
							}
						}
					}else if(!orientation.equals("NO") || !orientation.equals("SO")) {
						throw new MyException("la posicion LEFT no puede ser llenada con orientaciones diferentes a NO, SE");
					}
				}
				if (position.equals("RIGHT")) {
					if (orientation.equals("SE")) {
						row = x / 2;
						column = x - 1;

						for (int i = 1; i <= (x * x); i++) {
							magicSquare[row][column] = i;
							rowAc = row;
							colAc = column;
							row += 1;
							column += 1;
							if (row == x) {
								row = 0;
							}
							if (column == -1) {
								column = x - 1;
							}
							if (column == x) {
								column = 0;
							}
							if (magicSquare[row][column] != 0) {
								row = rowAc;
								column = colAc - 1;
							}
						}
					} else if (orientation.equals("NE")) {
						row = x / 2;
						column = x - 1;

						for (int i = 1; i <= (x * x); i++) {
							magicSquare[row][column] = i;
							rowAc = row;
							colAc = column;
							row -= 1;
							column += 1;
							if (row == -1) {
								row = x - 1;
							}
							if (column == x) {
								column = 0;
							}
							if (magicSquare[row][column] != 0) {
								row = rowAc;
								column = colAc - 1;
							}
						}
					}else if(!orientation.equals("NE") || !orientation.equals("SE")) {
						throw new MyException("la posicion RIGHT no puede ser llenado en una direccion diferente a NE, SE");
					}
				}
			}else if(x%2 ==0){
				throw new IsNotOddOrNullException("Digite un numero impar por favor");
			}else if(position == null || orientation == null){
				throw new IsNotOddOrNullException("Seleccione una posicion y una direccion");
			}
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int magicConstant() {
		return (int) (x * ((x * x) + 1)) / 2;
	}

	public int[][] getMatrix() {
		return magicSquare;
	}

}
