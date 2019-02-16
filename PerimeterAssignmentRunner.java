package Perim_Of_Shape2;

import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
       int NumberOfPoints=0;
        for(Point p:s.getPoints())
        {
           NumberOfPoints=NumberOfPoints+1;
           

        }
        return NumberOfPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
         double totalPerim=0;
        Point prevPt = s.getLastPoint();
        for(Point currPt:s.getPoints())
        {
           double currDist = prevPt.distance(currPt);
           totalPerim = totalPerim + currDist;
           prevPt = currPt;
           
           
        
        }
        double NumberOfPoints=getNumPoints(s);
        double averageLength=totalPerim/NumberOfPoints;
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double LargestDist=0;
        double prevDist=0;
        for(Point currPt:s.getPoints())
        {
            
            double currDist = prevPt.distance(currPt);
            
            
            if(prevDist>currDist)
            {
                LargestDist=prevDist;
            }
            else
            {
                LargestDist=currDist;
          
            }
            prevDist = currDist;
            prevPt=currPt;
            
            
            
        }
        return LargestDist;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double X = (s.getLastPoint()).getX();
        double LargestX=0;
        double prevX=0;
        for(Point currPt:s.getPoints())
        {
            double CurrX = currPt.getX();
            if(prevX>CurrX)
            {
                LargestX=prevX;
            }
            else
            {
                LargestX=CurrX;
          
            }
            prevX=CurrX;
            prevPt=currPt;
            
            
            
        }
        return LargestX;
    }

    public double getLargestPerimeterMultipleFiles() {
       DirectoryResource dr = new DirectoryResource();
       double last_perim=0;
       double largest_perim=0;
       
 for (File f : dr.selectedFiles()) {
     FileResource fr = new FileResource(f); 
     Shape s = new Shape(fr);
     double curr_perim = getPerimeter(s);
     if(last_perim>curr_perim)
     {
       largest_perim=last_perim;
        }
        else
        {
            largest_perim=curr_perim;
        }
        last_perim=curr_perim;
 }
        return largest_perim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        File Current=null;
        double last_perim=0;
        double largest_perim=0;
        File LargestFile = null;
        File last=null;
        for (File f : dr.selectedFiles()) {
     FileResource fr = new FileResource(f); 
     Shape s = new Shape(fr);
     double curr_perim = getPerimeter(s);
     File current=f;
     if(last_perim>curr_perim)
     {
       largest_perim=last_perim;
        LargestFile = last;
        }
        else
        {
            largest_perim=curr_perim;
             LargestFile = current;
        }
        last_perim=curr_perim;
        last=current;
       
 }
          // replace this code
        return LargestFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int NumberOfPoints=getNumPoints(s);
        double averageLength=getAverageLength(s);
        double LargestDist=getLargestSide(s);
        double LargestX=getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("This shape has "+NumberOfPoints+" points");
        System.out.println("The average of all sides is " + averageLength);
        System.out.println("The largest side is "+ LargestDist);
        System.out.println("The largest x is "+LargestX);
    }
    
    public void testPerimeterMultipleFiles() {
      
        // Put code here
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        double length=getLargestPerimeterMultipleFiles();
        String Largest = getFileWithLargestPerimeter();
        System.out.println("This is the largest perimeter of all the shapes "+ length + " and it's from the file "+ Largest);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testFileWithLargestPerimeter();
        pr.testPerimeter();
    }
}
