/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   main.c                                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: gman <marvin@42.fr>                        +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/08/28 17:38:26 by gman              #+#    #+#             */
/*   Updated: 2019/08/28 21:56:49 by gman             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "bsq.h"

int		main(int argc, char **argv)
{
	char *solution;

	solution = 0;
	if (argc > 1)
	{
		solution = bsq(argv[1]);
		if (!solution)
			ft_putstr("map error\n");
	}
	return (0);
}
