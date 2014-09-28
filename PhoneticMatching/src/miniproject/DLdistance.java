/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;


public class DLdistance
{
	
	public int damlev(String s, String t)
	{
		int l1 = s.length();
		int l2 = t.length();
		int m = l1 + 1;
		int n = l2 + 1;
		if (m == 1)
			return n - 1;
		if (n == 1)
			return m -1;
		int[] d = new int[m * n];
		int k = 0;
		for (int i = 0; i < n; i++)
			d[i] = i;
		k = n;
		for (int i = 1; i < m; i++)
		{
			d[k] = i;
			k += n;
		}
		int f = 0, g = 0, h = 0, min = 0, b = 0, c = 0, cost = 0, tr = 0;
		for (int i = 1; i < n; i++)
		{
			k = i;
			f = 0;
			for (int j = 1; j < m; j++)
			{
				h = k;
				k += n;
				min = d[h] + 1;
				b = d[k - 1] + 1;
				if (g < l1 && f < l2)
					if (s.charAt(g) == t.charAt(f))
						cost = 0;
					else
					{
						cost = 1;
						/* Sean's transposition */
						if (j < l2 && i < l1)
								if (s.charAt(i) == t.charAt(f) && s.charAt(g) == t.charAt(j))
								{
									tr = d[(h) - 1]/* + 1*/; // transposition yields deletion cost at next iteration?
									if (tr < min)
										min = tr;
								}
					}
				else
					cost = 1;
				c = d[h - 1] + cost;
				if (b < min)
					min = b;
				if (c < min)
					min = c;
				d[k] = min;
				/*
				System.out.println("i=" + i + ", j=" + j);
				for (int v = 0; v < m; v++)
				{
					for (int w = 0; w < n; w++)
						System.out.print(d[v * n + w] + " ");
					System.out.println();
				}
				*/
				f = j;
			}
			g = i;
		}
		return d[k];
        }
}

