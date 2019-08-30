/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   map_validation.c                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tiyu <marvin@42.fr>                        +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/08/28 16:13:32 by tiyu              #+#    #+#             */
/*   Updated: 2019/08/28 22:50:20 by gman             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "bsq.h"

int			**map_validation(char *map)
{
	char	arr[2];
	int		**array;
	char	*ptr;

	array = 0;
	g_width = 0;
	if (!(g_height = ft_atoi(map)))
		return (0);
	map = map + get_digit_count(g_height);
	while (map[g_width] && map[g_width] != '\n')
		g_width++;
	if (g_width < 3)
		return (0);
	g_width = -1;
	ptr = map;
	while (g_width++ != 2)
		arr[g_width] = map[g_width];
	g_rect = ptr[2];
	map = ptr + 4;
	if ((g_width = check_map((ptr + g_width + 1), arr[0], arr[1])))
		array = generate_array((ptr + 4), arr[0], g_height, g_width);
	else
		return (0);
	return (array);
}
