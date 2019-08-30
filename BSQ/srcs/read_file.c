/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   read_file.c                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tiyu <marvin@42.fr>                        +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/08/28 16:13:53 by tiyu              #+#    #+#             */
/*   Updated: 2019/08/28 20:51:30 by gman             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "bsq.h"

char		*read_file(char *path)
{
	int		file;
	int		size;
	char	*str;
	char	c;

	size = 0;
	file = open(path, O_RDONLY);
	if (file < 0)
		return (0);
	while (read(file, &c, 1))
		size++;
	close(file);
	str = (char *)malloc(sizeof(char) * size);
	file = open(path, O_RDONLY);
	size = 0;
	while (read(file, &c, 1))
		str[size++] = c;
	close(file);
	if (!str)
		return (NULL);
	return (str);
}
