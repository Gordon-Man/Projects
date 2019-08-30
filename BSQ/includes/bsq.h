/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   bsq.h                                              :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: tiyu <marvin@42.fr>                        +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2019/08/28 16:09:23 by tiyu              #+#    #+#             */
/*   Updated: 2019/08/28 20:26:56 by gman             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#ifndef BSQ_H
# define BSQ_H
# include <stdlib.h>
# include <unistd.h>
# include <fcntl.h>

int		g_height;
int		g_width;
char	g_rect;
int		ft_atoi(char *str);
int		get_digit_count(int i);
int		check_map(char *map, char path, char obstacle);
int		grow_square(int **map, int x, int y);
int		**generate_array(char *map, char path, int g_height, int g_width);
int		**map_validation(char *map);
char	*bsq(char *path);
char	*read_file(char *path);
char	*get_solution(char *map, int **array);
void	trav_map(int **array, char *map, int *ia);
void	print_solution(char *map, int *ia);
void	ft_putchar(char c);
void	ft_putstr(char *str);

#endif
