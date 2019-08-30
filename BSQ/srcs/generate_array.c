/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   generate_array.c                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tiyu <marvin@42.fr>                        +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/08/28 16:12:44 by tiyu              #+#    #+#             */
/*   Updated: 2019/08/28 21:52:01 by gman             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "bsq.h"

int		**generate_array(char *map, char path, int g_height, int g_width)
{
	int i;
	int j;
	int **arr;

	i = -1;
	arr = (int **)malloc(g_height * sizeof(int*));
	while (i++ < g_width)
		arr[i] = (int *)malloc(g_width * sizeof(int));
	i = 0;
	j = 0;
	while (*map)
	{
		if (*map == '\n')
		{
			i++;
			j = -1;
		}
		else if (*map == path)
			arr[i][j] = 1;
		else
			arr[i][j] = 0;
		j++;
		map++;
	}
	return (arr);
}
