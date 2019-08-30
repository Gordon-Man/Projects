/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   bsq.c                                              :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tiyu <marvin@42.fr>                        +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/08/28 16:18:03 by tiyu              #+#    #+#             */
/*   Updated: 2019/08/28 21:38:50 by gman             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "bsq.h"

char		*bsq(char *path)
{
	int		**array;
	char	*map;

	map = read_file(path);
	if (!map)
		return (0);
	array = map_validation(map);
	if (array == 0)
		return (0);
	else
		map = map + 4;
	map = get_solution(map, array);
	ft_putstr(map + 1);
	free(array);
	return (map);
}
