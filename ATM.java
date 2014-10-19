public class ATM {
	public static int x=7;
	public static int y=0;
	public static int z=10;
	public static void main(String[] args) {
		int amount=3600;	
//		userAmount1(amount);
		userAmount2(amount);
	}
	public static void userAmount1(int amount) {
		if(amount%100 != 0) {
			System.out.println("Wrong amount entered!!");
			return;
		} else if(amount%500 > (x*100)) {
			System.out.println("Can't provide requested amount");
			return;
		} else if(amount > (x*100+y*500+z*1000)) {
			System.out.println("Can't provide requested amount");
			return;
		} else {
			int i=0,j=0,k=0,pri=0;
			double px=(x*100)/amount, py=(y*500)/amount, pz=(z*1000)/amount;
			while((amount-pri) > 1000 && z>0) {
				pri+=1000;
				z--; k++;
			}
			while((amount-pri) > 500 && y>0) {
				pri+=500;
				y--; j++;
			}
			while((amount-pri) >= 100 && x>0) {
				pri+=100;
				x--; i++;
			}
			if(amount-pri > 0 && amount-pri < 1000) {
				pri+=500;
				y--; j++;
			} else if(amount-pri > 0 && amount-pri > 500) {
				pri+=1000;
				z--; k++;
			}
			if(amount-pri == 0) {
				System.out.println("100's="+i+", 500's="+j+", 1000's="+k);
				return;
			} else {
				System.out.println("Can't provide requested amount");
				return;
			}
		}
	}
	public static void userAmount2(int amount) {
		if(amount%100 != 0) {
			System.out.println("Wrong amount entered!!");
			return;
		} else if(amount%500 > (x*100)) {
			System.out.println("Can't provide requested amount");
			return;
		} else if(amount > (x*100+y*500+z*1000)) {
			System.out.println("Can't provide requested amount");
			return;
		} else {
			int i=0,j=0,k=0,pri=0,yf=0,zf=0;
			while(true) {
				double px=(x*100)/(amount-pri), py=(y*500)/(amount-pri), pz=(z*1000)/(amount-pri);
				int flag=pri;
				if(zf == 0 && pz > 0 && pz >= px && pz >= py) {
					if(pri+1000 >= amount)
						zf=1;
					else {
						pri+=1000;
						z--; k++;
					}
				}
				px=(x*100)/(amount-pri); py=(y*500)/(amount-pri); pz=(z*1000)/(amount-pri);
				if(yf == 0 && py > 0 && py >= px && py >= pz) {
					if(pri+500 >= amount)
						yf=1;
					else {
						pri+=500;
						y--; j++;
					}
				}
				px=(x*100)/(amount-pri); py=(y*500)/(amount-pri); pz=(z*1000)/(amount-pri);
				if(x>0 && px >= py && px >= pz) {
					pri+=100;
					x--; i++;
				}
				if(flag==pri) {
					if(amount-pri > 0 && amount-pri < 500) {
//						System.out.println("Here1");
						int p=(amount-pri);
						int q=500-(amount-pri);
						if(x >= p/100) {
							x-=p/100; i+=p/100;
							pri=amount;
						} else {
							if(y>0) {
								y--; j++;
								x+=q/100; i-=(q/100);
								pri=amount;
							} else {
								z--; k++;
								x+=(500+q)/100; i-=(500+q)/100;
								pri=amount;
							}
						}
					} else if(amount-pri > 0 && amount-pri < 1000) {
//						System.out.println("Here2");
						int p=(amount-pri);
						int q=(amount-pri)-500;
						int r=1000-(amount-pri);
						if(p == 500) {
							if(y > 0) {
								j++; y--;
								pri=amount;
							} else if(j>0 && z>0){
								j--; y++;
								z--; k++;
								pri=amount;
							} else {
								z--; k++;
								i-=(p/100); x+=(p/100);
								pri=amount;
							}
						} else {
							if(j > 0 && i >= r/100) {
								y++; j--;
								z--; k++;
								i-=(r/100); x+=(r/100);
								pri=amount;
							} else if(y > 0 && x >= q/100) {
								x-=(q/100); y--; j++; i+=(q/100);
								pri=amount;
							} else if(x >= (p/100)) {
								x-=(p/100); i+=(p/100);
								pri=amount;
							}
						}
					} else if(amount-pri >= 1000){
//						System.out.println("Here3");
						if(x>0) {
							pri+=100;
							x--; i++;
						} else if(y>0) {
							pri+=500;
							y--; j++;
						} else if(z>0) {
							pri+=1000;
							z--; k++;
						}
					}
				}
				if(pri == amount) {
					System.out.println("100's="+i+", 500's="+j+", 1000's="+k);
					return;
				}
			}
		}
	}
}
