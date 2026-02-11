-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 26 Jan 2023 pada 03.47
-- Versi server: 10.4.25-MariaDB
-- Versi PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `booking_lapangan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `loguser`
--

CREATE TABLE `loguser` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `loguser`
--

INSERT INTO `loguser` (`id`, `username`, `email`, `password`) VALUES
(4, 'test_12', 'test12@test.com', 'test123412'),
(8, 'rezn', 'test5@test.com', '12345'),
(9, 'zinc', 'test1@gmail.com', '12345'),
(10, 'a', 'a', 'a'),
(11, 'b', 'b', 'b');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_booking_badminton`
--

CREATE TABLE `tb_booking_badminton` (
  `kd_booking` varchar(50) NOT NULL,
  `tgl_booking` date NOT NULL,
  `tgl_main` date NOT NULL,
  `kasir` varchar(50) NOT NULL,
  `penyewa` varchar(50) NOT NULL,
  `status` varchar(20) NOT NULL,
  `lapangan` varchar(20) NOT NULL,
  `harga_sewa` int(50) NOT NULL,
  `masuk` varchar(10) NOT NULL,
  `keluar` varchar(10) NOT NULL,
  `lama` int(2) NOT NULL,
  `total` int(20) NOT NULL,
  `dp` int(20) NOT NULL,
  `sisa` int(20) NOT NULL,
  `keterangan` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_booking_futsal`
--

CREATE TABLE `tb_booking_futsal` (
  `kd_booking` varchar(50) NOT NULL,
  `tgl_booking` date NOT NULL,
  `tgl_main` date NOT NULL,
  `kasir` varchar(50) NOT NULL,
  `penyewa` varchar(50) NOT NULL,
  `status` varchar(20) NOT NULL,
  `lapangan` varchar(20) NOT NULL,
  `harga_sewa` int(50) NOT NULL,
  `masuk` varchar(10) NOT NULL,
  `keluar` varchar(10) NOT NULL,
  `lama` int(2) NOT NULL,
  `total` int(50) NOT NULL,
  `dp` int(50) NOT NULL,
  `sisa` int(50) NOT NULL,
  `keterangan` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_booking_voli`
--

CREATE TABLE `tb_booking_voli` (
  `kd_booking` varchar(50) NOT NULL,
  `tgl_booking` date NOT NULL,
  `tgl_main` date NOT NULL,
  `kasir` varchar(50) NOT NULL,
  `penyewa` varchar(50) NOT NULL,
  `status` varchar(20) NOT NULL,
  `lapangan` varchar(20) NOT NULL,
  `harga_sewa` int(50) NOT NULL,
  `masuk` varchar(10) NOT NULL,
  `keluar` varchar(10) NOT NULL,
  `lama` int(2) NOT NULL,
  `total` int(20) NOT NULL,
  `dp` int(20) NOT NULL,
  `sisa` int(20) NOT NULL,
  `keterangan` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `loguser`
--
ALTER TABLE `loguser`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tb_booking_badminton`
--
ALTER TABLE `tb_booking_badminton`
  ADD PRIMARY KEY (`kd_booking`);

--
-- Indeks untuk tabel `tb_booking_futsal`
--
ALTER TABLE `tb_booking_futsal`
  ADD PRIMARY KEY (`kd_booking`);

--
-- Indeks untuk tabel `tb_booking_voli`
--
ALTER TABLE `tb_booking_voli`
  ADD PRIMARY KEY (`kd_booking`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `loguser`
--
ALTER TABLE `loguser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
