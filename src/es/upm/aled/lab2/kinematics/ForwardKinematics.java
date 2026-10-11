package es.upm.aled.lab2.kinematics;
import java.util.ArrayList;
import java.util.List;

import es.upm.aled.lab2.gui.Node;

/**
 * This class implements a forward kinematics algorithm using recursion. It
 * expects a tree of Segments (defined by its length and angle with respect to
 * the previous Segment in the tree) and returns a tree of Nodes (defined by
 * their absolute coordinates in a 2-dimensional space).
 * 
 * @author rgarciacarmona
 */
public class ForwardKinematics {

	/**
	 * Returns a tree of Nodes to be used by SkeletonPanel to draw the position of
	 * an exoskeleton. This method is the public facade to a recursive method that
	 * builds the result from a tree of Segments defined by their angle and length,
	 * and the relationship between them (which Segment is children of which).
	 * 
	 * @param root    The root of the tree of Segments.
	 * @param originX The X coordinate for the origin point of the tree.
	 * @param originY The Y coordinate for the origin point of the tree.
	 * @return The tree of Nodes that represent the exoskeleton position in absolute
	 *         coordinates.
	 */
	// Public method: returns the root of the position tree: MÉTODO FACHADA
	public static Node computePositions(Segment root, double originX, double originY) {
		 return computePositions(root, originX, originY, 0.0);
		
		
	}

	// Private helper method that implements the recursive algorithm: MÉTODO RECURSIVO
	private static Node computePositions(Segment link, double baseX, double baseY, double accumulatedAngle) {
		long startTime= System.nanoTime();
			
		accumulatedAngle+=link.getAngle();
		double x= baseX + link.getLength()*Math.cos(accumulatedAngle);
		double y= baseY + link.getLength()*Math.sin(accumulatedAngle);
		Node node=new Node(x,y); //genero el nodo de a donde llego 
		
		if(link.getChildren().isEmpty()) {
			long runningTime = System.nanoTime()- startTime; 
			System.out.println("Tiempo de computePositions para un segmento con " + link.getChildren().size() + " hijos: " + runningTime + " nanosegundos");//caso base
			return node;
		}
		for (Segment child: link.getChildren()) {
			node.addChild(computePositions(child,x,y,accumulatedAngle));
			long runningTime = System.nanoTime()- startTime; 
			System.out.println("Tiempo de computePositions para un segmento con " + link.getChildren().size() + " hijos: " + runningTime + " nanosegundos");
		
		
		}
		return node;
		
	
		
		
		
		
		
		
		
		
		

		
		
	
		
		
		
		
		
		}
			
}