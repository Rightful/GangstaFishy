package main.java.Model;

import java.awt.Polygon;
import java.util.Arrays;

@SuppressWarnings("serial")
public class BoundsPro extends Polygon{
	
	private int width, height, x, y;
	
	
	public void translateTo(int x, int y){
		int minX = getMinX();
		int minY = getMinY();
		for(int i = 0; i < npoints; i++){
//			System.out.println("BoundsPro: "+xpoints[i] +" - " + minX +" + "+ x);
			xpoints[i] += - minX + x;
			ypoints[i] += - minY + y;
		}
	}
	
	public void setPolygon(Polygon p){
		
		for(int i = 0; i < p.npoints; i++){
			this.addPoint(p.xpoints[i], p.ypoints[i]);
		}
		calculateSizeAndPosition();
	}
	
	public void calculateSizeAndPosition() {
		calcWidth();
		calcHeight();
	}
	
	public void scaleTo(int w, int h){
		scaleXto(w);
		scaleYto(h);
		calculateSizeAndPosition();
	}
	
	private void scaleXto(int toX){
		calcWidth();
		int basic = getMinX();
		
		
		double scale, w = width, x = toX;
//		if(width>toX){
			scale= w/x;
//			System.out.println(width +"/" + toX + "=" + scale + " alt " + (214/300));
//		}else{
//			System.out.println(width +"<" + toX);
//			scale = toX/width;
//		}
//			System.out.println(xpoints[0] + "/" + width/toX + "="+(xpoints[0]/scale));
		for(int i = 0; i < this.xpoints.length; i++) {
			this.xpoints[i] = (int) (this.xpoints[i]/scale);// + basic;
//			this.xpoints[i] = (int) (toX*100/this.xpoints[i]);
        }
//		System.out.println("width = " + width + "\n===");
	}
	
	private void scaleYto(int toY){
		calcHeight();
		int basic = getMinY();
		double scale, h = height, y = toY;
		
		scale = h/y;
		for(int i = 0; i < this.ypoints.length; i++) {
			this.ypoints[i] = (int) (this.ypoints[i]/scale);// + basic;
//			this.ypoints[i] = (int) (toY*100/ypoints[i]);
            
        }
	}
	
	private void calcWidth(){
		double max = -900000
				,min = getMinX(), w;
		
		
        for(int i = 0; i < this.xpoints.length; i++) {
            if(max < this.xpoints[i]){
            	max = this.xpoints[i];
            }
        }
        
        w = max - min;
        x = (int)min;
    	width = (int)w;
	}
	
	private void calcHeight(){
		double max = -900000,
				min = getMinY(), w;
		
		
        for(int i = 0; i < this.ypoints.length; i++) {
            if(max < this.ypoints[i]){
            	max = this.ypoints[i];
            }
        }
        
        w = max - min;
        
        y = (int)min;
    	height = (int)w;
	}
	private int getMinX(){
		int[] wtf = Arrays.copyOf(xpoints, npoints);
		Arrays.sort(wtf);
        return  wtf[0];
	}
	
	private int getMinY(){
		int[] wtf = Arrays.copyOf(ypoints, npoints);
		Arrays.sort(wtf);
        return  wtf[0];
	}
	
	

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
