/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   check_map.c                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tiyu <marvin@42.fr>                        +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/08/28 16:13:00 by tiyu              #+#    #+#             */
/*   Updated: 2019/08/28 22:48:59 by gman             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "bsq.h"

int		check_map(char *map, char path, char obstacle)
{
	int line_length;
	int next_lines;

	next_lines = 0;
	line_length = 0;
	while (*(map++) != '\n' && (*map))
		line_length++;
	if (!*map)
		return (0);
	while (*map)
	{
		if (*map != '\n' && *map != path && *map != obstacle)
			return (0);
		else if ((next_lines == line_length) && *map != '\n')
			return (0);
		else
			next_lines++;
		if (line_length + 1 > next_lines && *map == '\n')
			return (0);
		if (*map == '\n')
			next_lines = 0;
		map++;
	}
	return (line_length);
}
