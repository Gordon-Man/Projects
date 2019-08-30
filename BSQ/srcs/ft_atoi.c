/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_atoi.c                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tiyu <marvin@42.fr>                        +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/08/28 16:03:53 by tiyu              #+#    #+#             */
/*   Updated: 2019/08/28 16:54:56 by gman             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "bsq.h"

int			ft_atoi(char *str)
{
	double	sum;
	int		flag;

	sum = 0;
	flag = 1;
	while ((*str >= 9 && *str <= 13)\
			|| *str == ' ' || *str == '0' || *str == '+')
		str++;
	if (*str == '-')
	{
		str++;
		flag = -1;
	}
	while (*str)
	{
		if (*str >= 48 && *str <= 57)
			sum = (sum + (*str - 48)) * 10;
		else
			return (sum / 10 * flag);
		str++;
	}
	return ((sum / 10) * flag);
}
