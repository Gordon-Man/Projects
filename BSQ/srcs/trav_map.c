/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   trav_map.c                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tiyu <marvin@42.fr>                        +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/08/28 17:42:40 by tiyu              #+#    #+#             */
/*   Updated: 2019/08/28 20:23:23 by gman             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "bsq.h"

void	trav_map(int **array, char *map, int *ia)
{
	while (*map)
	{
		while (ia[0] < g_height)
		{
			while (ia[1] < g_width)
			{
				if (grow_square(array, ia[0], ia[1]) > ia[4])
				{
					ia[4] = grow_square(array, ia[0], ia[1]);
					ia[2] = ia[0];
					ia[3] = ia[1];
				}
				ia[1]++;
			}
			ia[1] = 0;
			ia[0]++;
		}
		map++;
	}
}
