/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   print_solution.c                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: gman <marvin@42.fr>                        +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/08/28 17:39:58 by gman              #+#    #+#             */
/*   Updated: 2019/08/28 21:55:19 by gman             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "bsq.h"

char		*get_solution(char *map, int **array)
{
	int		*ia;
	char	*ptr;

	ia = (int *)malloc(sizeof(int) * 5);
	ia[0] = 0;
	ia[1] = 0;
	ia[2] = 0;
	ia[3] = 0;
	ia[4] = 0;
	ptr = map;
	trav_map(array, ptr, ia);
	ia[0] = 0;
	ia[1] = 0;
	ptr++;
	print_solution(ptr, ia);
	return (map);
}
