/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   grow_square.c                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tiyu <marvin@42.fr>                        +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/08/28 16:17:50 by tiyu              #+#    #+#             */
/*   Updated: 2019/08/28 18:13:54 by gman             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "bsq.h"

int			grow_square(int **map, int x, int y)
{
	int		expanded;
	int		i;
	int		run;

	expanded = -1;
	run = 0;
	i = 0;
	while ((x + i) < g_height && (y + i) < g_width
		&& map[x + i][y] != 0 && map[x][y + i] != 0)
	{
		while (map[x + i][y + run] != 0 && map[x + run][y + i] != 0 && run < i)
			run++;
		if (run == i && map[x + i][y + i] != 0)
		{
			run = 0;
			expanded++;
		}
		else
			break ;
		i++;
	}
	return (expanded);
}
