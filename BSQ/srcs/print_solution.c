/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   print_solution.c                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: gman <marvin@42.fr>                        +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/08/28 18:03:44 by gman              #+#    #+#             */
/*   Updated: 2019/08/28 20:27:23 by gman             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "bsq.h"

void	print_solution(char *map, int *iarray)
{
	while (iarray[0] != iarray[4] + 1)
	{
		while (iarray[1] != iarray[4] + 1)
		{
			map[((iarray[2] + iarray[1]) * g_width) + \
				iarray[3] + iarray[0] + iarray[1]] = g_rect;
			iarray[1]++;
		}
		iarray[1] = 0;
		iarray[0]++;
	}
}
